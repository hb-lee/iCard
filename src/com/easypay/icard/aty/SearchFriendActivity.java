package com.easypay.icard.aty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.easypay.icard.R;

public class SearchFriendActivity extends Activity {

	private TextView cancelText = null;
	private EditText searchContent = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchfriend);
		init();
	}

	private void init() {
		cancelText = (TextView)findViewById(R.id.searchfriend_cancel);
		searchContent = (EditText)findViewById(R.id.searchfriend_content);
	}

	@Override
	public void onBackPressed() {
		finish();
		super.onBackPressed();
	}
}
