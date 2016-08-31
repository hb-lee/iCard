package com.easypay.icard.aty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.easypay.icard.R;

public class DonateCardActivity extends Activity {
	
	private ImageButton backTo = null;
	private ListView listView = null;
	private Button donateDone = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.donatecard);
		init();
	}

	private void init() {
		backTo = (ImageButton)findViewById(R.id.donatecard_back);
		listView = (ListView)findViewById(R.id.donatecard_listview);
		donateDone = (Button)findViewById(R.id.donatecard_btn);
	}

}
