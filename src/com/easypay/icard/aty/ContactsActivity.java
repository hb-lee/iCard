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

public class ContactsActivity extends Activity {

	private ImageButton backTo = null;
	private TextView addText = null;
	private ListView listView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);
		init();
	}

	private void init() {
		backTo = (ImageButton) findViewById(R.id.contacts_back);
		addText = (TextView) findViewById(R.id.contacts_add_friends);
		listView = (ListView) findViewById(R.id.contacts_listview);

		backTo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), OwnActivity.class);
				startActivity(intent);
				finish();
			}
		});

		addText.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(),
						SearchFriendActivity.class);
				startActivity(intent);
			}
		});

		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
				R.layout.contacts_list_item,
				new String[] { "name", "account" }, new int[] {
						R.id.contacts_list_item_name,
						R.id.contacts_list_item_account });
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(),
						PersonInfoActivity.class);
				startActivity(intent);
			}
		});
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "张三");
		map.put("account", "10001000");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "张三");
		map.put("account", "10001000");
		list.add(map);
		return list;
	}

}
