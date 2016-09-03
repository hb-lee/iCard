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
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

import com.easypay.icard.R;

public class TypeDisplayActivity extends Activity {

	private ImageButton backTo = null;
	private GridView gridView = null;
	private String[] iconName = { "超市", "咖啡厅", "餐厅", "书店", "网吧", "电影院", "音乐厅",
			"KTV" };
	private int[] icon = { R.drawable.market_icon, R.drawable.coffee_icon,
			R.drawable.resturant_icon, R.drawable.bookstore_icon,
			R.drawable.netbar_icon, R.drawable.movies_icon,
			R.drawable.odeum_icon, R.drawable.ktv_icon };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.typedisplay);
		init();
	}

	private void init() {
		backTo = (ImageButton) findViewById(R.id.typedisplay_back);
		gridView = (GridView) findViewById(R.id.typedisplay_gridView);

		backTo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), BusinessActivity.class);
				startActivity(intent);
				finish();
			}
		});

		SimpleAdapter adapterGrid = new SimpleAdapter(this, getGridData(),
				R.layout.grid_item, new String[] { "icon", "text" }, new int[] {
						R.id.grid_item_image, R.id.grid_item_text });
		gridView.setAdapter(adapterGrid);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), ItemListActivity.class);
				startActivity(intent);
				finish();
			}
		});
		gridView.setAdapter(adapterGrid);
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
}
