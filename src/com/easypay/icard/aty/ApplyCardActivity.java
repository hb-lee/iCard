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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.easypay.icard.R;

public class ApplyCardActivity extends Activity {

	private ImageButton backTo = null;
	private EditText applyeeName = null;
	private EditText applyeePhone = null;
	private EditText vCode = null;
	private Button vCodeBtn = null;
	private ListView listView = null;
	private Button applyCardDone = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.applycard);
		init();
	}

	private void init() {
		backTo = (ImageButton) findViewById(R.id.applycard_back);
		applyeeName = (EditText) findViewById(R.id.applycard_name_input);
		applyeePhone = (EditText) findViewById(R.id.applycard_phone_input);
		vCode = (EditText) findViewById(R.id.applycard_vcode);
		vCodeBtn = (Button) findViewById(R.id.applycard_vcode_btn);
		listView = (ListView) findViewById(R.id.applycard_listView);
		applyCardDone = (Button) findViewById(R.id.applycard_done);

		backTo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(),
						BusinessDetailActivity.class);
				startActivity(intent);
				finish();
			}
		});

		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
				R.layout.applycard_list_item,
				new String[] { "picture", "intro" }, new int[] {
						R.id.applycard_list_item_pic,
						R.id.applycard_list_item_intro });
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(),
						CardFunctionActivity.class);
			}
		});

		applyCardDone.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String string = new String();
				string = "姓名为：" + applyeeName.getText().toString() + "电话为："
						+ applyeePhone.getText().toString();
				Toast.makeText(getApplicationContext(), string,
						Toast.LENGTH_SHORT);
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(),
						ApplySuccessActivity.class);
			}
		});
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("picture", R.drawable.demo1);
		map.put("intro",
				"这是一个历史悠久的富含韵味的非常好吃的点，里面环境好，风景好，人好，山好，什么都很好，值得来光临，而且价格优惠，欢迎品尝！！！");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.demo2);
		map.put("intro",
				"这是一个历史悠久的富含韵味的非常好吃的点，里面环境好，风景好，人好，山好，什么都很好，值得来光临，而且价格优惠，欢迎品尝！！！");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.demo3);
		map.put("intro",
				"这是一个历史悠久的富含韵味的非常好吃的点，里面环境好，风景好，人好，山好，什么都很好，值得来光临，而且价格优惠，欢迎品尝！！！");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("picture", R.drawable.demo4);
		map.put("intro",
				"这是一个历史悠久的富含韵味的非常好吃的点，里面环境好，风景好，人好，山好，什么都很好，值得来光临，而且价格优惠，欢迎品尝！！！");
		list.add(map);
		return list;
	}

}
