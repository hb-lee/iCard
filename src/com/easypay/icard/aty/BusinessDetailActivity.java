package com.easypay.icard.aty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.easypay.icard.R;

public class BusinessDetailActivity extends Activity {

	private ImageButton backTo = null;
	private TextView titleBar = null;
	private ImageButton ticketDone = null;
	private ImageView businessPic = null;
	private TextView gradeTotal = null;
	private TextView phoneOfBusiness = null;
	private ImageView mapBusiness = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.businessdetail);
		init();

		titleBar.setText("春城杜老鲜麻辣烫");
		businessPic.setBackgroundResource(R.drawable.demo1);
		gradeTotal.append("9.5/10.0");
		phoneOfBusiness.append("13484939584");
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
	}

}
