package com.easypay.icard.aty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.easypay.icard.R;

public class ContactsActivity extends Activity {
	
	private ImageButton backTo = null;
	private TextView addText = null;
	private ListView listView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);
		init();
	}

	private void init() {
		backTo = (ImageButton)findViewById(R.id.contacts_back);
		addText = (TextView)findViewById(R.id.contacts_add_friends);
		listView = (ListView)findViewById(R.id.contacts_listview);
	}

}
