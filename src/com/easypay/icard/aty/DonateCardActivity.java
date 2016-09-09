package com.easypay.icard.aty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.easypay.icard.R;

public class DonateCardActivity extends Activity {
	
	private ImageButton backTo = null;
	private ListView listView = null;
	private Button donateDone = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.donatecard);
		init();
	}

	private void init() {
		backTo = (ImageButton)findViewById(R.id.donatecard_back);
		listView = (ListView)findViewById(R.id.donatecard_listview);
		donateDone = (Button)findViewById(R.id.donatecard_btn);
		
		
		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
				R.layout.card_list_item, new String[] { "description" },
				new int[] { R.id.card_list_item_textview });
		listView.setAdapter(adapter);
		
		
		backTo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(),
						PersonInfoActivity.class);
				startActivity(intent);
			}
		});
		
		donateDone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new AlertDialog.Builder(DonateCardActivity.this).setTitle("提示")
				.setMessage("您确定要把卡赠送给对方？")
				 .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮
					 @Override
					 public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件
						 Toast.makeText(getApplicationContext(), "卡已赠送!", Toast.LENGTH_SHORT).show();
							Intent intent = new Intent();
							intent.setClass(getApplicationContext(),
									PersonInfoActivity.class);
							startActivity(intent);
							finish();
					 }
				 }).setNegativeButton("取消",new DialogInterface.OnClickListener() {//添加返回按钮
					 @Override
					 public void onClick(DialogInterface dialog, int which) {//响应事件
						 Toast.makeText(getApplicationContext(), "您已取消赠送", Toast.LENGTH_SHORT).show();
						 finish();
					 }
				 }).show();//在按键响应事件中显示此对话框
				
				
			}
		});
	}
	
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("description", "合佳超市");
		list.add(map);

		return list;
	}
}
