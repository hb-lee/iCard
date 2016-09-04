package com.easypay.icard.aty;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.easypay.icard.R;

public class NearActivity extends Activity {
	// 百度地图控件
			private MapView mMapView = null;
			// 百度地图对象
			private BaiduMap bdMap;
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				requestWindowFeature(Window.FEATURE_NO_TITLE);
				//
				SDKInitializer.initialize(getApplicationContext());
				setContentView(R.layout.near);
				init();
			}

			/**
			 * 初始化方法
			 */
			private void init() {
				mMapView = (MapView) findViewById(R.id.near_map);
				//bdMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
			}
			@Override
			protected void onResume() {
				mMapView.setVisibility(View.VISIBLE);   
		        mMapView.onResume();   
		        super.onResume();   
			}
			@Override
			protected void onPause() {
				mMapView.setVisibility(View.INVISIBLE);   
			    mMapView.onPause();   
			    super.onPause(); 
			}
			@Override
			protected void onDestroy() {
				mMapView.onDestroy();
				mMapView = null;
				super.onDestroy();
			}
}
