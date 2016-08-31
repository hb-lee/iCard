package com.easypay.icard.aty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.easypay.icard.R;

public class BusinessActivity extends Activity {

	private ImageButton refreshImgBtn = null;
	private EditText searchContent = null;
	private ImageButton qrImgBtn = null;
	private GridView gridView = null;
	private ListView listView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.business);
		init();
	}

	private void init() {
		refreshImgBtn = (ImageButton)findViewById(R.id.business_refresh);
		searchContent = (EditText)findViewById(R.id.business_search_text);
		qrImgBtn = (ImageButton)findViewById(R.id.business_QRcode);
		gridView = (GridView)findViewById(R.id.business_gridview);
		listView = (ListView)findViewById(R.id.business_listview);
	}

}
