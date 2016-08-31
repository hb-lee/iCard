package com.easypay.icard.aty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.easypay.icard.R;

public class CardDetailActivity extends Activity {

	private ImageButton backTo = null;
	private ImageView cardPhoto = null;
	private TextView cardRange = null;
	private TextView cardHolder = null;
	private TextView cardBalance = null;
	private TextView cardCredits = null;
	private TextView cardNumber = null;
	private TextView launchPhone = null;
	private TextView launchCharge = null;
	private TextView launchLogout = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.carddetail);
		init();
	}
	private void init() {
		backTo = (ImageButton)findViewById(R.id.carddetail_back);
		cardPhoto = (ImageView)findViewById(R.id.carddetail_card_photo);
		cardRange = (TextView)findViewById(R.id.carddetail_range);
		cardHolder = (TextView)findViewById(R.id.carddetail_holder);
		cardBalance = (TextView)findViewById(R.id.carddetail_balance);
		cardCredits = (TextView)findViewById(R.id.carddetail_credits);
		cardNumber = (TextView)findViewById(R.id.carddetail_number);
		launchPhone = (TextView)findViewById(R.id.carddetail_phone);
		launchCharge = (TextView)findViewById(R.id.carddetail_charge);
		launchLogout = (TextView)findViewById(R.id.carddetail_logout);
		
	}

}
