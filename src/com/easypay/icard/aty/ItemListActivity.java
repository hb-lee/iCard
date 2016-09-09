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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.easypay.icard.R;

public class ItemListActivity extends Activity {

	private ImageButton backTo = null;
	private TextView titleBar = null;
	private ListView listView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itemlist);
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
				Bundle bundle = new Bundle();
				bundle.putString("activity", "IndexActivity");
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
		
		backTo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), BusinessActivity.class);
				startActivity(intent);
			}
		});
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
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
		
		map.put("imageView", R.drawable.example_index_b1);
		map.put("title", "春城杜老鲜麻辣烫");
		map.put("info", "【红旗街店】不好吃分文不取");
		map.put("memberPrice", "会员:25元");
		map.put("itemPrice", "原价:28元");
		map.put("times", "106人/天");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.example_index_b2);
		map.put("title", "阿满食品");
		map.put("info", "【红旗街店】好吃又实惠");
		map.put("memberPrice", "会员:32元");
		map.put("itemPrice", "原价:35元");
		map.put("times", "78人/天");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.example_index_b3);
		map.put("title", "咖啡优尼(COFFEE YOUNET)");
		map.put("info", "【大智路204号】浪漫才是经典");
		map.put("memberPrice", "会员:27元");
		map.put("itemPrice", "原价:30元");
		map.put("times", "123人/天");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.example_index_b4);
		map.put("title", "张亮麻辣烫连锁店");
		map.put("info", "【吉大南校店】好吃随便选，我们不一样");
		map.put("memberPrice", "会员:12元");
		map.put("itemPrice", "原价:15元");
		map.put("times", "154人/天");
		list.add(map);
		return list;
	}
	
	private void init() {
		Bundle bundle = getIntent().getExtras();
		backTo = (ImageButton)findViewById(R.id.itemlist_back);
		titleBar = (TextView)findViewById(R.id.itemlist_title);
		listView = (ListView)findViewById(R.id.itemlist_listview);
		titleBar.setText(bundle.getString("type").toString());
	}
	
}
