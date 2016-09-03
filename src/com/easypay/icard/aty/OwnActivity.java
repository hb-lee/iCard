package com.easypay.icard.aty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.easypay.icard.R;

public class OwnActivity extends Activity {

	private TextView billText = null;
	private ImageButton friendsImgBtn = null;
	private ImageButton addImgBtn = null;
	private ImageView ownPhoto = null;
	private TextView ownName = null;
	private TextView ownPhone = null;
	private RelativeLayout ownParcel = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.own);
		init();
	}

	private void init() {
		billText = (TextView)findViewById(R.id.own_bill);
		friendsImgBtn = (ImageButton)findViewById(R.id.own_friends);
		addImgBtn = (ImageButton)findViewById(R.id.own_add);
		ownPhoto = (ImageView)findViewById(R.id.own_photo);
		ownName = (TextView)findViewById(R.id.own_name);
		ownPhone = (TextView)findViewById(R.id.own_phone);
		ownParcel = (RelativeLayout)findViewById(R.id.own_parcel);
		
		billText.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), BillListActivity.class);
				startActivity(intent);
			}
		});
		
		friendsImgBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), ContactsActivity.class);
				startActivity(intent);
			}
		});
		
		addImgBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), SearchFriendActivity.class);
				startActivity(intent);
			}
		});
		
		ownName.append("张三");
		ownPhone.append("13435839493");
		
		ownParcel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), CardListActivity.class);
				startActivity(intent);
			}
		});
	}

}
