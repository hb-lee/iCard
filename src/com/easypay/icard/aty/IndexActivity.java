package com.easypay.icard.aty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.easypay.icard.R;

public class IndexActivity extends Activity {

	private ImageView topImage = null;
	private TextView adsTextTitle1 = null;
	private TextView adsTextTitle2 = null;
	private TextView adsTextTitle3 = null;
	private TextView adsTextTitle4 = null;
	private TextView adsTextContent1 = null;
	private TextView adsTextContent2 = null;
	private TextView adsTextContent3 = null;
	private TextView adsTextContent4 = null;
	private ImageView adsImage1 = null;
	private ImageView adsImage2 = null;
	private ImageView adsImage3 = null;
	private ImageView adsImage4 = null;
	private ListView listView = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);
		init();
	}


	private void init() {
		topImage = (ImageView)findViewById(R.id.index_topimage);
		adsTextTitle1 = (TextView)findViewById(R.id.index_ads_text_up_1);
		adsTextTitle2 = (TextView)findViewById(R.id.index_ads_text_up_2);
		adsTextTitle3 = (TextView)findViewById(R.id.index_ads_text_up_3);
		adsTextTitle4 = (TextView)findViewById(R.id.index_ads_text_up_4);
		adsTextContent1 = (TextView)findViewById(R.id.index_ads_text_down_1);
		adsTextContent2 = (TextView)findViewById(R.id.index_ads_text_down_2);
		adsTextContent3 = (TextView)findViewById(R.id.index_ads_text_down_3);
		adsTextContent4 = (TextView)findViewById(R.id.index_ads_text_down_4);
		adsImage1 = (ImageView)findViewById(R.id.index_ads_image1);
		adsImage2 = (ImageView)findViewById(R.id.index_ads_image2);
		adsImage3 = (ImageView)findViewById(R.id.index_ads_image3);
		adsImage4 = (ImageView)findViewById(R.id.index_ads_image4);
		listView = (ListView)findViewById(R.id.index_listview);
	}

}
