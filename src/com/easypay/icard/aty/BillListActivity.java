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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.easypay.icard.R;

public class BillListActivity extends Activity {

	private ImageButton backTo = null;
	private ListView listView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.billlist);
		init();
	}

	private void init() {
		backTo = (ImageButton) findViewById(R.id.billlist_back);
		listView = (ListView) findViewById(R.id.billlist_listview);

		backTo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), OwnActivity.class);
				startActivity(intent);
				finish();
			}
		});

		SimpleAdapter adapter = new SimpleAdapter(
				this,
				getData(),
				R.layout.bill_list_item,
				new String[] { "data", "account", "reason" },
				new int[] { R.id.bill_list_item_date,
						R.id.bill_list_item_account, R.id.bill_list_item_reason });
		listView.setAdapter(adapter);
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", "8月1日");
		map.put("account", "50元");
		map.put("reason", "小木人火锅");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("data", "8月1日");
		map.put("account", "50元");
		map.put("reason", "小木人火锅");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("data", "8月1日");
		map.put("account", "50元");
		map.put("reason", "小木人火锅");
		list.add(map);
		return list;
	}

}
