package com.easypay.icard.aty;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.easypay.icard.R;

public class BusinessDetailActivity extends Activity {

	private ImageButton backTo = null;
	private TextView titleBar = null;
	private ImageButton ticketDone = null;
	private ImageView businessPic = null;
	private TextView gradeTotal = null;
	private TextView phoneOfBusiness = null;
	private ImageView mapBusiness = null;
	private TextView businessContents = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.businessdetail);
		init();

		// 收集Bundle
		Bundle bundle = this.getIntent().getExtras();
		if(bundle.getString("activity").equals("NearActivity")){
			titleBar.setText(bundle.getString("name"));
			businessPic.setBackgroundResource(R.drawable.example_index_b1);
			gradeTotal.append("9.5/10.0");
			phoneOfBusiness.append(bundle.getString("phoneNum"));
			businessContents.setText("所在城市：" + bundle.getString("city") + "\r\n"
													+ "邮编：" + bundle.getString("postCode") + "\r\n"
													+ "地址：" + bundle.getString("address"));
		} else {
			titleBar.setText(bundle.getString("name"));
			businessPic.setBackgroundResource(bundle.getInt("imageView"));
			gradeTotal.append("9.5/10.0");
			phoneOfBusiness.append("130 ****0000");
			businessContents.setText("店名：" + bundle.getString("name") + "\r\n"
					+ "信息：" + bundle.getString("info") + "\r\n"
				    + bundle.getString("memberPrice") + "\r\n"
					+ bundle.getString("itemPrice"));
			
		}
		
		backTo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), ItemListActivity.class);
				startActivity(intent);
			}
		});
		
		ticketDone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), ApplyCardActivity.class);
				startActivity(intent);
			}
		});
	}

	private void init() {
		backTo = (ImageButton) findViewById(R.id.businessdetail_back);
		titleBar = (TextView) findViewById(R.id.businessdetail_title);
		ticketDone = (ImageButton) findViewById(R.id.businessdetail_ticket);
		businessPic = (ImageView) findViewById(R.id.business_info_pic);
		gradeTotal = (TextView) findViewById(R.id.business_grade);
		phoneOfBusiness = (TextView) findViewById(R.id.business_phone);
		mapBusiness = (ImageView) findViewById(R.id.business_map);
		businessContents = (TextView)findViewById(R.id.businessdetail_contents);
	}

}
