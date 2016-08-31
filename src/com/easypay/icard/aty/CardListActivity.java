package com.easypay.icard.aty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import com.easypay.icard.R;

public class CardListActivity extends Activity {

	private ImageButton backTo = null;
	private ImageButton moreInfo = null;
	private ListView listView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cardlist);
		init();
	}

	private void init() {
		backTo = (ImageButton)findViewById(R.id.cardlist_back);
		moreInfo = (ImageButton)findViewById(R.id.cardlist_more);
		listView = (ListView)findViewById(R.id.cardlist_listview);
	}

}
