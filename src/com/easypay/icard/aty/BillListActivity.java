package com.easypay.icard.aty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import com.easypay.icard.R;

public class BillListActivity extends Activity {

	private ImageButton backTo = null;
	private ListView listView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.billlist);
		init();
	}

	private void init() {
		backTo = (ImageButton)findViewById(R.id.billlist_back);
		listView = (ListView)findViewById(R.id.billlist_listview);
	}

}
