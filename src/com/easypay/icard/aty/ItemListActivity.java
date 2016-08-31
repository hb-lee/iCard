package com.easypay.icard.aty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.easypay.icard.R;

public class ItemListActivity extends Activity {

	private ImageButton backTo = null;
	private TextView titleBar = null;
	private ListView listView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itemlist);
		init();
	}

	private void init() {
		backTo = (ImageButton)findViewById(R.id.itemlist_back);
		titleBar = (TextView)findViewById(R.id.itemlist_title);
		listView = (ListView)findViewById(R.id.itemlist_listview);
	}
	
}
