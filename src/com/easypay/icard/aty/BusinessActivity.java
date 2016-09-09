package com.easypay.icard.aty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.easypay.icard.R;
import com.google.zxing.ui.CaptureActivity;

public class BusinessActivity extends Activity {

	private EditText searchContent = null;
	private ImageButton qrImgBtn = null;
	private GridView gridView = null;
	private ListView listView = null;
	private String[] iconName = { "超市", "咖啡厅", "餐厅", "书店", "更多" };
	private int[] icon = { R.drawable.market_icon, R.drawable.coffee_icon,
			R.drawable.resturant_icon, R.drawable.bookstore_icon, R.drawable.more_icon };
	public static final int SCAN_CODE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.business);
		init();

		SimpleAdapter adapterGrid = new SimpleAdapter(this, getGridData(),
				R.layout.grid_item, new String[] { "icon", "text" }, new int[] {
						R.id.grid_item_image, R.id.grid_item_text });
		gridView.setAdapter(adapterGrid);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if(arg2 < 4){
					Intent intent = new Intent();
					Bundle bundle = new Bundle();
					Map map = (HashMap) gridView.getItemAtPosition(arg2);
					bundle.putString("type", map.get("text").toString());
					intent.putExtras(bundle);
					intent.setClass(getApplicationContext(), ItemListActivity.class);
					startActivity(intent);
				} else {
					Log.e("mylog", "business gridview item 5 in");
					Intent intent = new Intent();
					intent.setClass(getApplicationContext(), TypeDisplayActivity.class);
					startActivity(intent);
				}
				
			}
		});
		
		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
				R.layout.common_list_item, new String[] { "imageView", "title",
						"info", "memberPrice", "itemPrice", "times" },
				new int[] { R.id.common_list_item_imageView,
						R.id.list_item_title, R.id.list_item_brief_info,
						R.id.list_item_member_price, R.id.list_item_price,
						R.id.list_item_times });
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("activity", "BusinessActivity");
				Map map = (HashMap) listView.getItemAtPosition(arg2);
				bundle.putString("name", map.get("title").toString());
				bundle.putInt("imageView", (Integer) map.get("imageView"));
				bundle.putString("info", map.get("info").toString());
				bundle.putString("memberPrice", map.get("memberPrice").toString());
				bundle.putString("itemPrice", map.get("itemPrice").toString());
				intent.putExtras(bundle);
				intent.setClass(getApplicationContext(), BusinessDetailActivity.class);
				startActivity(intent);
			}
		});
	}

	private List<Map<String, Object>> getGridData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < icon.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("icon", icon[i]);
			map.put("text", iconName[i]);
			list.add(map);
		}
		return list;
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.example_index_b5);
		map.put("title", "糖果KTV");
		map.put("info", "【硅谷大街店】高新开发区硅谷大街3666号（近广本城邦）");
		map.put("memberPrice", "会员:25元");
		map.put("itemPrice", "原价:28元");
		map.put("times", "64人/天");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.example_index_b6);
		map.put("title", "金牌烤场");
		map.put("info", "【欧亚卖场店】高新开发区开运街与飞跃路交汇5178号欧亚卖场18号门2楼");
		map.put("memberPrice", "会员:45元");
		map.put("itemPrice", "原价:49.9元");
		map.put("times", "232人/天");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.example_index_b7);
		map.put("title", "吉大巨幕影城");
		map.put("info", "【吉大南校】免费提供3D眼睛，无需押金");
		map.put("memberPrice", "会员:19.9元");
		map.put("itemPrice", "原价:24元");
		map.put("times", "874人/天");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.example_index_b4);
		map.put("title", "张亮麻辣烫麻辣烫");
		map.put("info", "【吉大南校店】好吃随便选，我们不一样");
		map.put("memberPrice", "会员:12元");
		map.put("itemPrice", "原价:15元");
		map.put("times", "154人/天");
		list.add(map);
		return list;
	}

	private void init() {
		searchContent = (EditText) findViewById(R.id.business_search_text);
		qrImgBtn = (ImageButton) findViewById(R.id.business_QRcode);
		gridView = (GridView) findViewById(R.id.business_gridview);
		listView = (ListView) findViewById(R.id.business_listview);
		
		qrImgBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(BusinessActivity.this, CaptureActivity.class);
                startActivityForResult(intent, SCAN_CODE);
			}
		});
	}

}
