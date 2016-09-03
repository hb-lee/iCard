package com.easypay.icard.aty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
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
		
		backTo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(),
						PersonInfoActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		donateDone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "卡已赠送!", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(),
						PersonInfoActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

}
