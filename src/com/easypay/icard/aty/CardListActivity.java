package com.easypay.icard.aty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.SimpleAdapter;

import com.easypay.icard.R;

public class CardListActivity extends Activity {

	private ImageButton backTo = null;
	private ImageButton moreInfo = null;
	private ListView listView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cardlist);
		init();
	}

	private void init() {
		backTo = (ImageButton) findViewById(R.id.cardlist_back);
		moreInfo = (ImageButton) findViewById(R.id.cardlist_more);
		listView = (ListView) findViewById(R.id.cardlist_listview);

		backTo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), OwnActivity.class);
				startActivity(intent);
			}
		});

		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
				R.layout.card_list_item, new String[] { "description" },
				new int[] { R.id.card_list_item_textview });
		listView.setAdapter(adapter);
		
		moreInfo.setOnClickListener(new OnClickListener() {
			
			PopupMenu popup = null;
			@Override
			public void onClick(View v) {
				popup = new PopupMenu(getApplicationContext(), v);
				getMenuInflater().inflate(R.menu.popu_more_card,
						popup.getMenu());
				popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						switch (item.getItemId()) {
						// 添加会员卡
						case R.id.menu_add_card:
							startActivity(new Intent(
									getApplicationContext(),
									BusinessActivity.class));
							finish();
							break;

						// 赠送会员卡
						case R.id.menu_donate_card:
							startActivity(new Intent(
									getApplicationContext(),
									DonateCardActivity.class));
							break;

						// 取消
						case R.id.menu_cancel:
							popup.dismiss();
							break;
						}
						return true;
					}
				});
				popup.show();
			}
		});
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("description", "合佳超市");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("description", "合佳超市");
		list.add(map);
		return list;
	}

}
