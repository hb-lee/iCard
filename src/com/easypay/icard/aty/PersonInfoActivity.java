package com.easypay.icard.aty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.easypay.icard.R;

public class PersonInfoActivity extends Activity {
	
	private ImageButton backTo = null;
	private ImageView personPhoto = null;
	private TextView personName = null;
	private TextView personAccount = null;
	private TextView personGender = null;
	private Button donateBtn = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personinfo);
		init();
	}

	private void init() {
		backTo = (ImageButton)findViewById(R.id.personinfo_back);
		personPhoto = (ImageView)findViewById(R.id.personinfo_pic);
		personName = (TextView)findViewById(R.id.personinfo_name);
		personAccount = (TextView)findViewById(R.id.personinfo_account);
		personGender = (TextView)findViewById(R.id.personinfo_gender);
		donateBtn = (Button)findViewById(R.id.personinfo_donate_btn);
		
		backTo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(),
						ContactsActivity.class);
				startActivity(intent);
			}
		});
		
		personName.append("张三");
		personAccount.append("10001000");
		personGender.append("男");
		
		donateBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(),
						DonateCardActivity.class);
				startActivity(intent);
			}
		});
	}

}
