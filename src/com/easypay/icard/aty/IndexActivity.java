package com.easypay.icard.aty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.easypay.icard.R;

public class IndexActivity extends Activity implements OnClickListener {

	private ImageView topImage = null;
	private TextView adsTextTitle1 = null;
	private TextView adsTextTitle2 = null;
	private TextView adsTextTitle3 = null;
	private TextView adsTextTitle4 = null;
	private LinearLayout adsLayout1 = null;
	private LinearLayout adsLayout2 = null;
	private LinearLayout adsLayout3 = null;
	private LinearLayout adsLayout4 = null;
	private TextView adsTextContent1 = null;
	private TextView adsTextContent2 = null;
	private TextView adsTextContent3 = null;
	private TextView adsTextContent4 = null;
	private ImageView adsImage1 = null;
	private ImageView adsImage2 = null;
	private ImageView adsImage3 = null;
	private ImageView adsImage4 = null;
	private ListView listView = null;
	 private ViewPager viewPager;
	    private LinearLayout point_group;
	    private TextView image_desc;
	    private final int[] images = {R.drawable.example_index_top1, R.drawable.example_index_top2, R.drawable.example_index_top3,
	            R.drawable.example_index_top4, R.drawable.example_index_top5};
	    // 图片标题集合
	    private final String[] imageDescriptions = {"美食不断",
	            "新电影", "欢乐中秋", "疯狂抢购", "回味肯德基"};
	    private ArrayList<ImageView> imageList;
	    // 上一个页面的位置
	    protected int lastPosition = 0;

	    // 判断是否自动滚动viewPager
	    private boolean isRunning = true;
	    private Handler handler = new Handler() {
	        public void handleMessage(android.os.Message msg) {
	            // 执行滑动到下一个页面
	            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
	            if (isRunning) {
	                // 在发一个handler延时
	                handler.sendEmptyMessageDelayed(0, 5000);
	            }
	        }
	    };
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);
		init();
		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
				R.layout.common_list_item, new String[] { "imageView", "title",
						"info", "memberPrice", "itemPrice", "times"},
				new int[] { R.id.common_list_item_imageView,
						R.id.list_item_title, R.id.list_item_brief_info,
						R.id.list_item_member_price, R.id.list_item_price,
						R.id.list_item_times });
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int arg2,
					long arg3) {
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("activity", "IndexActivity");
				Map map = (HashMap) listView.getItemAtPosition(arg2);
				bundle.putString("name", map.get("title").toString());
				bundle.putInt("imageView", (Integer) map.get("imageView"));
				bundle.putString("info", map.get("info").toString());
				bundle.putString("memberPrice", map.get("memberPrice").toString());
				bundle.putString("itemPrice", map.get("itemPrice").toString());
				intent.putExtras(bundle);
				intent.setClass(getApplicationContext(), BusinessDetailActivity.class);
				startActivity(intent);
			}
		});
		
		viewPager = (ViewPager) findViewById(R.id.viewPager);
        point_group = (LinearLayout) findViewById(R.id.point_group);
        image_desc = (TextView) findViewById(R.id.image_desc);
        image_desc.setText(imageDescriptions[0]);

        // 初始化图片资源
        imageList = new ArrayList<ImageView>();
        for (int i : images) {
            // 初始化图片资源
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(i);
            imageList.add(imageView);

            // 添加指示小点
            ImageView point = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100,
                    15);
            params.rightMargin = 20;
            params.bottomMargin = 10;
            point.setLayoutParams(params);
            point.setBackgroundResource(R.drawable.point_bg);
            if (i == R.drawable.example_index_top1) {
                //默认聚焦在第一张
                point.setBackgroundResource(R.drawable.point_bg_focus);
                point.setEnabled(true);
            } else {
                point.setEnabled(false);
            }

            point_group.addView(point);
        }

        viewPager.setAdapter(new MyPageAdapter());
        // 设置当前viewPager的位置
        viewPager.setCurrentItem(Integer.MAX_VALUE / 2
                - (Integer.MAX_VALUE / 2 % imageList.size()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // 页面切换后调用， position是新的页面位置

                // 实现无限制循环播放
                position %= imageList.size();

                image_desc.setText(imageDescriptions[position]);

                // 把当前点设置为true,将上一个点设为false；并设置point_group图标
                point_group.getChildAt(position).setEnabled(true);
                point_group.getChildAt(position).setBackgroundResource(R.drawable.point_bg_focus);//设置聚焦时的图标样式
                point_group.getChildAt(lastPosition).setEnabled(false);
                point_group.getChildAt(lastPosition).setBackgroundResource(R.drawable.point_bg);//上一张恢复原有图标
                lastPosition = position;

            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                // 页面正在滑动时间回调

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // 当pageView 状态发生改变的时候，回调

            }
        });

        /**
         * 自动循环： 1.定时器：Timer 2.开子线程：while true循环 3.ClockManger
         * 4.用Handler发送延时信息，实现循环，最简单最方便
         *
         */

        handler.sendEmptyMessageDelayed(0, 3000);
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.example_index_b1);
		map.put("title", "春城杜老鲜麻辣烫");
		map.put("info", "【红旗街店】不好吃分文不取");
		map.put("memberPrice", "会员:25元");
		map.put("itemPrice", "原价:28元");
		map.put("times", "106人/天");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.example_index_b2);
		map.put("title", "阿满食品");
		map.put("info", "【红旗街店】好吃又实惠");
		map.put("memberPrice", "会员:32元");
		map.put("itemPrice", "原价:35元");
		map.put("times", "78人/天");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.example_index_b3);
		map.put("title", "咖啡优尼(COFFEE YOUNET)");
		map.put("info", "【大智路204号】浪漫才是经典");
		map.put("memberPrice", "会员:27元");
		map.put("itemPrice", "原价:30元");
		map.put("times", "123人/天");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("imageView", R.drawable.example_index_b4);
		map.put("title", "张亮麻辣烫连锁店");
		map.put("info", "【吉大南校店】好吃随便选，我们不一样");
		map.put("memberPrice", "会员:12元");
		map.put("itemPrice", "原价:15元");
		map.put("times", "154人/天");
		list.add(map);
		return list;
	}

	private void init() {
		//topImage = (ImageView) findViewById(R.id.index_topimage);
		adsLayout1 = (LinearLayout)findViewById(R.id.index_ads1);
		adsLayout2 = (LinearLayout)findViewById(R.id.index_ads2);
		adsLayout3 = (LinearLayout)findViewById(R.id.index_ads3);
		adsLayout4 = (LinearLayout)findViewById(R.id.index_ads4);
		adsTextTitle1 = (TextView) findViewById(R.id.index_ads_text_up_1);
		adsTextTitle2 = (TextView) findViewById(R.id.index_ads_text_up_2);
		adsTextTitle3 = (TextView) findViewById(R.id.index_ads_text_up_3);
		adsTextTitle4 = (TextView) findViewById(R.id.index_ads_text_up_4);
		adsTextContent1 = (TextView) findViewById(R.id.index_ads_text_down_1);
		adsTextContent2 = (TextView) findViewById(R.id.index_ads_text_down_2);
		adsTextContent3 = (TextView) findViewById(R.id.index_ads_text_down_3);
		adsTextContent4 = (TextView) findViewById(R.id.index_ads_text_down_4);
		adsImage1 = (ImageView) findViewById(R.id.index_ads_image1);
		adsImage2 = (ImageView) findViewById(R.id.index_ads_image2);
		adsImage3 = (ImageView) findViewById(R.id.index_ads_image3);
		adsImage4 = (ImageView) findViewById(R.id.index_ads_image4);
		listView = (ListView) findViewById(R.id.index_listview);
		
		adsLayout1.setOnClickListener(this);
		adsLayout2.setOnClickListener(this);
		adsLayout3.setOnClickListener(this);
		adsLayout4.setOnClickListener(this);
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View arg0) {
		switch(arg0.getId()){
		case R.id.index_ads1:
			Toast.makeText(getApplicationContext(), "您点击了广告栏 " + adsTextTitle1.getText().toString() + "\r\n" + adsTextContent1.getText().toString(), Toast.LENGTH_SHORT).show();
			break;
		case R.id.index_ads2:
			Toast.makeText(getApplicationContext(), "您点击了广告栏 " + adsTextTitle2.getText().toString() + "\r\n" + adsTextContent2.getText().toString(), Toast.LENGTH_SHORT).show();
			break;
		case R.id.index_ads3:
			Toast.makeText(getApplicationContext(), "您点击了广告栏 " + adsTextTitle3.getText().toString() + "\r\n" + adsTextContent3.getText().toString(), Toast.LENGTH_SHORT).show();
			break;
		case R.id.index_ads4:
			Toast.makeText(getApplicationContext(), "您点击了广告栏 " + adsTextTitle4.getText().toString() + "\r\n" + adsTextContent4.getText().toString(), Toast.LENGTH_SHORT).show();
			break;
		}
	}
	
	private class MyPageAdapter extends PagerAdapter {
        // 需要实现以下四个方法

        @Override
        public int getCount() {
            // 获得页面的总数
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            // 判断view和Object对应是否有关联关系
            if (view == object) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // 获得相应位置上的view； container view的容器，其实就是viewpage自身,
            // position: viewpager上的位置
            // 给container添加内容
            container.addView(imageList.get(position % imageList.size()));

            return imageList.get(position % imageList.size());
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // 销毁对应位置上的Object
            // super.destroyItem(container, position, object);
            container.removeView((View) object);
            object = null;
        }
	}

}
