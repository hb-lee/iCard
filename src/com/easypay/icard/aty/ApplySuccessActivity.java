package com.easypay.icard.aty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.easypay.icard.R;

public class ApplySuccessActivity extends Activity {

	private ImageButton backTo = null;
	private TextView titleBar = null;
	private TextView applyResult = null;
	private ImageView qrPic = null;
	private TextView cardNumber = null;
	private TextView cardBalance = null;
	private TextView cardCredits = null;
	private Button chargeBtn = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.applysuccess);
		init();
	}

	private void init() {
		backTo = (ImageButton)findViewById(R.id.applysuccess_back);
		titleBar = (TextView)findViewById(R.id.applysuccess_title);
		applyResult = (TextView)findViewById(R.id.applysuccess_result);
		qrPic = (ImageView)findViewById(R.id.applysuccess_QRcode);
		cardNumber = (TextView)findViewById(R.id.applysuccess_card_number);
		cardBalance = (TextView)findViewById(R.id.applysuccess_card_balance);
		cardCredits = (TextView)findViewById(R.id.applysuccess_card_credit);
		chargeBtn = (Button)findViewById(R.id.applysuccess_btn);
	}
	
}
