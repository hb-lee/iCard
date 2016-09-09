package com.easypay.icard.aty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerDragListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.overlayutil.PoiOverlay;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.poi.PoiSortType;
import com.easypay.icard.R;

public class NearActivity extends Activity implements OnClickListener,
		OnGetPoiSearchResultListener {

	private MapView mMapView = null;
	private BaiduMap mBaiduMap = null;
	private PoiSearch mPoiSearch = null;
	private LocationClient locClient = null;
	private boolean isFirstLoc = true;
	private Marker marker = null;
	private double latitude, longitude;

	private EditText searchWords = null;
	private Button searchBtn = null;
	private Button normalBtn = null;
	private Button satelliteBtn = null;
	private Button locationBtn = null;

	BitmapDescriptor bitmap = BitmapDescriptorFactory
			.fromResource(R.drawable.own_location);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.near);
		initView();
	}

	public void initView() {
		mMapView = (MapView) findViewById(R.id.near_map);
		MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(15.0f);
		mBaiduMap = mMapView.getMap();
		mBaiduMap.setMapStatus(msu);

		searchWords = (EditText) findViewById(R.id.near_etSearch);
		searchBtn = (Button) findViewById(R.id.near_btnSearch);
		normalBtn = (Button) findViewById(R.id.near_btn1);
		satelliteBtn = (Button) findViewById(R.id.near_btn2);
		locationBtn = (Button) findViewById(R.id.request_replace);

		searchBtn.setOnClickListener(this);
		normalBtn.setOnClickListener(this);
		satelliteBtn.setOnClickListener(this);
		locationBtn.setOnClickListener(this);
		normalBtn.setEnabled(false);
		mBaiduMap.setMyLocationEnabled(true);

		locClient = new LocationClient(getApplicationContext());
		locClient.registerLocationListener(locListener);
		// 配置定位SDK参数
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(com.baidu.location.LocationClientOption.LocationMode.Hight_Accuracy);
		option.setIsNeedAddress(true);
		option.setLocationNotify(true);
		option.setOpenGps(true);
		option.setIsNeedLocationPoiList(true);
		option.setIgnoreKillProcess(false);
		option.SetIgnoreCacheException(false);
		option.setEnableSimulateGps(false);
		option.setCoorType("bd09ll");
		option.setAddrType("all");
		option.setScanSpan(1000);
		locClient.setLocOption(option);
		Log.e("mylog", "before init poisearch");

		// 初始化搜索模块，注册搜索事件监听
		mPoiSearch = PoiSearch.newInstance();
		mPoiSearch.setOnGetPoiSearchResultListener(this);
		Log.e("mylog", "after init poisearch");
		// 对marker覆盖物添加点击事件
		mBaiduMap.setOnMarkerClickListener(new OnMarkerClickListener() {

			@Override
			public boolean onMarkerClick(Marker arg0) {
				if (arg0 == marker) {
					final LatLng latLng = arg0.getPosition();
					Toast.makeText(getApplicationContext(), "您点击了maker",
							Toast.LENGTH_SHORT);
					return true;
				}
				return false;
			}
		});

		/**
		 * 地图点击事件
		 */
		mBaiduMap.setOnMapClickListener(new OnMapClickListener() {

			@Override
			public boolean onMapPoiClick(MapPoi arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void onMapClick(LatLng arg0) {
				Toast.makeText(getApplicationContext(), "捕获到地图点击事件",
						Toast.LENGTH_SHORT).show();
			}
		});
		Log.e("mylog", "--------");
		/**
		 * 拖拽事件
		 */
		mBaiduMap.setOnMarkerDragListener(new OnMarkerDragListener() {

			@Override
			public void onMarkerDragStart(Marker arg0) {
				Toast.makeText(getApplicationContext(), "捕获到maker的开始拖拽事件",
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onMarkerDragEnd(Marker arg0) {
				Toast.makeText(getApplicationContext(), "捕获到maker的终止拖拽事件",
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onMarkerDrag(Marker arg0) {
				LatLng l = new LatLng(latitude, longitude);
				reverseGeoCode(l);
				// Toast.makeText(getApplicationContext(), "捕获到maker的拖拽事件" + ,
				// Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void reverseGeoCode(LatLng latLng) {
		// 创建地理编码检索实例
		GeoCoder geoCoder = GeoCoder.newInstance();
		OnGetGeoCoderResultListener listener = new OnGetGeoCoderResultListener() {
			// 反地理编码查询结果回调函数
			@Override
			public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {
				if (result == null
						|| result.error != SearchResult.ERRORNO.NO_ERROR) {
					// 没有检测到结果
					Toast.makeText(NearActivity.this, "抱歉，未能找到结果",
							Toast.LENGTH_LONG).show();
				}
				Toast.makeText(NearActivity.this, "位置：" + result.getAddress(),
						Toast.LENGTH_LONG).show();
			}

			// 地理编码查询结果回调函数
			@Override
			public void onGetGeoCodeResult(GeoCodeResult result) {
				if (result == null
						|| result.error != SearchResult.ERRORNO.NO_ERROR) {
					// 没有检测到结果
				}
			}
		};
		// 设置地理编码检索监听者
		geoCoder.setOnGetGeoCodeResultListener(listener);
		// 反地理编码需要传递坐标点
		geoCoder.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
		// 释放地理编码检索实例
		// geoCoder.destroy();
	}

	/**
	 * 添加标注覆盖物
	 */
	private void addMarkerOverlay() {
		mBaiduMap.clear();
		// 定义marker坐标点
		LatLng point = new LatLng(latitude, longitude);
		Log.e("mylog", "add MarkerOverlay latituede : " + latitude
				+ "longitude : " + longitude);
		// 构建markerOption，用于在地图上添加marker
		OverlayOptions options = new MarkerOptions()//
				.position(point)// 设置marker的位置
				.icon(bitmap)// 设置marker的图标
				.zIndex(30)// 設置marker的所在層級
				.draggable(true);// 设置手势拖拽
		// 在地图上添加marker，并显示
		marker = (Marker) mBaiduMap.addOverlay(options);
	}

	/**
	 * 定位监听器
	 */
	BDLocationListener locListener = new BDLocationListener() {

		// 定位请求回调函数
		@Override
		public void onReceiveLocation(BDLocation location) {
			Log.e("mylog", "onReceiveLocation in");
			if (location == null || mBaiduMap == null) {
				Toast.makeText(getApplicationContext(), "位置获取为空！",
						Toast.LENGTH_SHORT).show();
				return;
			}
			// 构造定位数据
			MyLocationData locData = new MyLocationData.Builder()
					.accuracy(location.getRadius())//
					.direction(100)// 方向
					.latitude(location.getLatitude())//
					.longitude(location.getLongitude())//
					.build();
			// 设置定位数据
			mBaiduMap.setMyLocationData(locData);
			latitude = location.getLatitude();
			longitude = location.getLongitude();
			//addMarkerOverlay();
			Log.e("mylog", "before judge isFirstLoc");
			// 第一次定位的时候，那地图中心点显示为定位到的位置
			if (isFirstLoc) {
				isFirstLoc = false;
				LatLng ll = new LatLng(location.getLatitude(),
						location.getLongitude());
				// MapStatusUpdate描述地图将要发生的变化
				// MapStatusUpdateFactory生成地图将要反生的变化
				MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(ll);
				mBaiduMap.animateMapStatus(msu);
				// bdMap.setMyLocationEnabled(false);
				Toast.makeText(getApplicationContext(),
						"得到了" + location.getAddrStr(), Toast.LENGTH_SHORT)
						.show();
			}
		}
	};

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.near_btn1:
			mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
			normalBtn.setEnabled(false);
			satelliteBtn.setEnabled(true);
			break;
		case R.id.near_btn2:
			mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
			satelliteBtn.setEnabled(false);
			normalBtn.setEnabled(true);
			break;
		case R.id.request_replace:
			locClient.start();
			addMarkerOverlay();
			LatLng ll = new LatLng(latitude, longitude);
			// MapStatusUpdate描述地图将要发生的变化
			// MapStatusUpdateFactory生成地图将要反生的变化
			MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(ll);
			mBaiduMap.animateMapStatus(msu);
			if (locClient == null) {
				Toast.makeText(getApplicationContext(), "定位为空",
						Toast.LENGTH_SHORT).show();
				return;
			}
			/*
			 * if(locClient.isStarted()){
			 * Toast.makeText(getApplicationContext(), "结束定位",
			 * Toast.LENGTH_SHORT).show(); locClient.stop(); } else {
			 */
			Toast.makeText(getApplicationContext(), "开始定位", Toast.LENGTH_SHORT)
					.show();
			// }
			break;
		case R.id.near_btnSearch:
			PoiNearbySearchOption option = new PoiNearbySearchOption();
			option.keyword(searchWords.getText().toString()).pageNum(1)
					.location(new LatLng(latitude, longitude)).pageCapacity(20)
					.radius(2000)
					.sortType(PoiSortType.distance_from_near_to_far);
			mPoiSearch.searchNearby(option);
			Toast.makeText(getApplicationContext(), "btnSearch" + latitude,
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onGetPoiDetailResult(PoiDetailResult result) {
		if (result.error != SearchResult.ERRORNO.NO_ERROR) {
			Toast.makeText(getApplicationContext(), "抱歉，未找到结果",
					Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(getApplicationContext(),
					result.getName() + ": " + result.getAddress(),
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onGetPoiIndoorResult(PoiIndoorResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetPoiResult(PoiResult result) {
		if (result == null
				|| result.error == SearchResult.ERRORNO.RESULT_NOT_FOUND) {
			Toast.makeText(NearActivity.this, "未找到结果", Toast.LENGTH_LONG)
					.show();
			return;
		}
		if (result.error == SearchResult.ERRORNO.NO_ERROR) {
			// 清除数据
			mBaiduMap.clear();
			// 添加poi覆盖物 并添加覆盖物的监听事件
			MyPoiOverlay overlay = new MyPoiOverlay(mBaiduMap);
			mBaiduMap.setOnMarkerClickListener(overlay);
			overlay.setData(result);
			overlay.addToMap();
			overlay.zoomToSpan();
			// showNearbyArea(center, radius);
			return;
		}
		if (result.error == SearchResult.ERRORNO.AMBIGUOUS_KEYWORD) {

			// 当输入关键字在本市没有找到，但在其他城市找到时，返回包含该关键字信息的城市列表
			String strInfo = "在";
			for (CityInfo cityInfo : result.getSuggestCityList()) {
				strInfo += cityInfo.city;
				strInfo += ",";
			}
			strInfo += "找到结果";
			Toast.makeText(NearActivity.this, strInfo, Toast.LENGTH_LONG)
					.show();
		}
	}

	private class MyPoiOverlay extends PoiOverlay {

		public MyPoiOverlay(BaiduMap baiduMap) {
			super(baiduMap);
		}

		@Override
		public boolean onPoiClick(int index) {
			super.onPoiClick(index);
			// PoiInfo类是poi信息类
			PoiInfo poi = getPoiResult().getAllPoi().get(index);
			// 判断poi点是否有美食类详情页面，这里也可以判断其它不是餐厅页面需要自己去查找方法api
			if (poi.hasCaterDetails == true) {
			// 返回该 poi 详情检索参数对象
			Toast.makeText(getApplicationContext(),
					"点击了poidetial" + poi.describeContents(), Toast.LENGTH_SHORT).show();
			Intent intent = new Intent();
			Bundle bundle = new Bundle();
			bundle.putString("activity", "NearActivity");
			bundle.putString("city", poi.city);
			bundle.putString("address", poi.address);
			bundle.putString("name", poi.name);
			bundle.putString("phoneNum", poi.phoneNum);
			bundle.putString("postCode", poi.postCode);
			//bundle.putInt("type", poi.type)
			intent.putExtras(bundle);
			intent.setClass(getApplicationContext(), BusinessDetailActivity.class);
			startActivity(intent);
			/*mPoiSearch.searchPoiDetail((new PoiDetailSearchOption())
					.poiUid(poi.uid));*/
			}
			return true;
		}
	}

	@Override
	protected void onDestroy() {
		Log.e("mylog", "destroy in");
		// 退出时销毁定位
		locClient.stop();
		mBaiduMap.setMyLocationEnabled(false);
		mMapView.onDestroy();
		mMapView = null;
		mPoiSearch.destroy();
		super.onDestroy();
		// 回收bitmip资源
		bitmap.recycle();
		Log.e("mylog", "destroy out");
	}

	@Override
	protected void onResume() {
		Log.e("mylog", "resume in");
		super.onResume();
		// 在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
		mMapView.onResume();
		Log.e("mylog", "resume out");
	}

	@Override
	protected void onPause() {
		Log.e("mylog", "pause in");
		super.onPause();
		// 在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
		mMapView.onPause();
		Log.e("mylog", "pause out");
	}
}
