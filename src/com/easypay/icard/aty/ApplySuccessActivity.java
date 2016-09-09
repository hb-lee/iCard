package com.easypay.icard.aty;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
		
		backTo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new AlertDialog.Builder(ApplySuccessActivity.this).setTitle("提示")
				.setMessage("亲现在有了本店的会员卡，想进行充值吗？")
				.setPositiveButton("不了，谢谢!", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						Intent intent = new Intent();
						intent.setClass(getApplicationContext(), ApplyCardActivity.class);
						startActivity(intent);
					}
				}).setNegativeButton("好的!", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						Toast.makeText(getApplicationContext(), "点击[我要充值]按钮进行充值!", Toast.LENGTH_SHORT).show();
					}
				}).show();
				
			}
		});
		
		cardNumber.append("0000000000");
		cardBalance.append("0元");
		cardCredits.append("0点");
		
		chargeBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "支付宝进行充值", Toast.LENGTH_SHORT).show();
			}
		});
	}
	
}
