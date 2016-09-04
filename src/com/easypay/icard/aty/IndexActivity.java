package com.easypay.icard.aty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.easypay.icard.R;

public class IndexActivity extends Activity {

	private ImageView topImage = null;
	private TextView adsTextTitle1 = null;
	private TextView adsTextTitle2 = null;
	private TextView adsTextTitle3 = null;
	private TextView adsTextTitle4 = null;
	private TextView adsTextContent1 = null;
	private TextView adsTextContent2 = null;
	private TextView adsTextContent3 = null;
	private TextView adsTextContent4 = null;
	private ImageView adsImage1 = null;
	private ImageView adsImage2 = null;
	private ImageView adsImage3 = null;
	private ImageView adsImage4 = null;
	private ListView listView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);
		init();
		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
				R.layout.common_list_item, new String[] { "imageView", "title",
						"info", "memberPrice", "itemPrice", "times"},
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
				intent.setClass(getApplicationContext(), BusinessDetailActivity.class);
				startActivity(intent);
			}
		});
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.demo1);
		map.put("title", "春城杜老鲜麻辣烫");
		map.put("info", "【红旗街店】不好吃分文不取");
		map.put("memberPrice", "25元");
		map.put("itemPrice", "28元");
		map.put("times", "106人/天");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.demo2);
		map.put("title", "阿满食品");
		map.put("info", "【红旗街店】好吃又实惠");
		map.put("memberPrice", "32元");
		map.put("itemPrice", "35元");
		map.put("times", "78人/天");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.demo3);
		map.put("title", "咖啡优尼(COFFEE YOUNET)");
		map.put("info", "【大智路204号】浪漫才是经典");
		map.put("memberPrice", "27元");
		map.put("itemPrice", "30元");
		map.put("times", "123人/天");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.demo4);
		map.put("title", "张亮麻辣烫麻辣烫");
		map.put("info", "【吉大南校店】好吃随便选，我们不一样");
		map.put("memberPrice", "12元");
		map.put("itemPrice", "15元");
		map.put("times", "154人/天");
		list.add(map);
		return list;
	}

	private void init() {
		topImage = (ImageView) findViewById(R.id.index_topimage);
		adsTextTitle1 = (TextView) findViewById(R.id.index_ads_text_up_1);
		adsTextTitle2 = (TextView) findViewById(R.id.index_ads_text_up_2);
		adsTextTitle3 = (TextView) findViewById(R.id.index_ads_text_up_3);
		adsTextTitle4 = (TextView) findViewById(R.id.index_ads_text_up_4);
		adsTextContent1 = (TextView) findViewById(R.id.index_ads_text_down_1);
		adsTextContent2 = (TextView) findViewById(R.id.index_ads_text_down_2);
		adsTextContent3 = (TextView) findViewById(R.id.index_ads_text_down_3);
		adsTextContent4 = (TextView) findViewById(R.id.index_ads_text_down_4);
		adsImage1 = (ImageView) findViewById(R.id.index_ads_image1);
		adsImage2 = (ImageView) findViewById(R.id.index_ads_image2);
		adsImage3 = (ImageView) findViewById(R.id.index_ads_image3);
		adsImage4 = (ImageView) findViewById(R.id.index_ads_image4);
		listView = (ListView) findViewById(R.id.index_listview);
		
		adsTextTitle1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "此处为4个广告栏", Toast.LENGTH_SHORT).show();
			}
		});
	}

}
