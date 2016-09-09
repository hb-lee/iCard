
package com.easypay.icard;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

import com.easypay.icard.aty.BusinessActivity;
import com.easypay.icard.aty.IndexActivity;
import com.easypay.icard.aty.NearActivity;
import com.easypay.icard.aty.OwnActivity;
public class ViewPagerActivity extends Activity {
	List<View> listViews = null;
	Context context = null;
	LocalActivityManager manager = null;
	TabHost tabHost = null;
	private ViewPager pager = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpager);
		context = ViewPagerActivity.this;
		pager  = (ViewPager) findViewById(R.id.viewpager);
		//定放一个放view的list，用于存放viewPager用到的view
		listViews = new ArrayList<View>();
		manager = new LocalActivityManager(this, true);
		manager.dispatchCreate(savedInstanceState);
		
		
		Intent i1 = new Intent(context, IndexActivity.class);
		listViews.add(getView("A", i1));
		Intent i2 = new Intent(context, NearActivity.class);
		listViews.add(getView("B", i2));
		Intent i3 = new Intent(context, BusinessActivity.class);
		listViews.add(getView("C", i3));
		Intent i4 = new Intent(context, OwnActivity.class);
		listViews.add(getView("D", i4));

		tabHost = (TabHost) findViewById(R.id.tabhost);
		tabHost.setup();
		tabHost.setup(manager);
		
		Log.e("mylog", "index in");
		//这儿主要是自定义一下tabhost中的tab的样式
		LinearLayout tabIndicator1 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.tabwidget, null);  
		TextView tvTab1 = (TextView)tabIndicator1.findViewById(R.id.viewpager_text);
		tvTab1.setText(R.string.index);
		ImageView imgTab1 = (ImageView)tabIndicator1.findViewById(R.id.viewpager_image);
		imgTab1.setBackgroundResource(R.drawable.index_blue_icon);
		Log.e("mylog", "index out");
		
		Log.e("mylog", "near in");
		LinearLayout tabIndicator2 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.tabwidget,null);  
		TextView tvTab2 = (TextView)tabIndicator2.findViewById(R.id.viewpager_text);
		tvTab2.setText(R.string.near);
		ImageView imgTab2 = (ImageView)tabIndicator2.findViewById(R.id.viewpager_image);
		imgTab2.setBackgroundResource(R.drawable.near_blue_icon);
		Log.e("mylog", "near out");
		
		Log.e("mylog", "business in");
		LinearLayout tabIndicator3 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.tabwidget,null);  
		TextView tvTab3 = (TextView)tabIndicator3.findViewById(R.id.viewpager_text);
		tvTab3.setText(R.string.business);
		ImageView imgTab3 = (ImageView)tabIndicator3.findViewById(R.id.viewpager_image);
		imgTab3.setBackgroundResource(R.drawable.business_blue_icon);
		Log.e("mylog", "business out");
		
		Log.e("mylog", "own in");
		LinearLayout tabIndicator4 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.tabwidget,null);  
		TextView tvTab4 = (TextView)tabIndicator4.findViewById(R.id.viewpager_text);
		tvTab4.setText(R.string.own);
		ImageView imgTab4 = (ImageView)tabIndicator4.findViewById(R.id.viewpager_image);
		imgTab4.setBackgroundResource(R.drawable.own_blue_icon);
		Log.e("mylog", "own out");
		
		Log.e("mylog", "intent change in");
		Intent intent = new Intent(context,EmptyActivity.class);
		//注意这儿Intent中的activity不能是自身 比如“A”对应的是T1Activity，后面intent就new的T3Activity的。
		tabHost.addTab(tabHost.newTabSpec("A").setIndicator(tabIndicator1).setContent(intent));
		Log.e("mylog", "intent change out");
		tabHost.addTab(tabHost.newTabSpec("B").setIndicator(tabIndicator2).setContent(intent));
		tabHost.addTab(tabHost.newTabSpec("C").setIndicator(tabIndicator3).setContent(intent));
		tabHost.addTab(tabHost.newTabSpec("D").setIndicator(tabIndicator4).setContent(intent));
		
		
		pager .setAdapter(new MyPageAdapter(listViews));
		pager .setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				//当viewPager发生改变时，同时改变tabhost上面的currentTab
				tabHost.setCurrentTab(position);
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		
	 //点击tabhost中的tab时，要切换下面的viewPager
	 tabHost.setOnTabChangedListener(new OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
            	if ("A".equals(tabId)) {
                    pager.setCurrentItem(0);
                } 
                if ("B".equals(tabId)) {
                    pager.setCurrentItem(1);
                } 
                if ("C".equals(tabId)) {
                    pager.setCurrentItem(2);
                } 
                if ("D".equals(tabId)) {
                    pager.setCurrentItem(3);
                } 
            }
        });
        
	}

	private View getView(String id, Intent intent) {
		return manager.startActivity(id, intent).getDecorView();
	}

	private class MyPageAdapter extends PagerAdapter {
		private List<View> list;
		private MyPageAdapter(List<View> list) {
			this.list = list;
		}

		@Override
        public void destroyItem(View view, int position, Object arg2) {
            ViewPager pViewPager = ((ViewPager) view);
            pViewPager.removeView(list.get(position));
        }

        @Override
        public void finishUpdate(View arg0) {
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object instantiateItem(View view, int position) {
            ViewPager pViewPager = ((ViewPager) view);
            pViewPager.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {
        }
	}

}
