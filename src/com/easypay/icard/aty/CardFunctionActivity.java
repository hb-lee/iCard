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

public class CardFunctionActivity extends Activity {

	private ImageButton backTo = null;
	private TextView titleBar = null;
	private ImageView cardPic = null;
	private TextView cardRights = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cardfunction);
		init();
	}

	private void init() {
		backTo = (ImageButton)findViewById(R.id.cardfunction_back);
		titleBar = (TextView)findViewById(R.id.cardfunction_title);
		cardPic = (ImageView)findViewById(R.id.cardfunction_card_pic);
		cardRights = (TextView)findViewById(R.id.rights_contents);
		
		backTo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), ApplyCardActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
	
}
