package com.easypay.icard;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

import com.easypay.icard.aty.BusinessActivity;
import com.easypay.icard.aty.IndexActivity;
import com.easypay.icard.aty.NearActivity;
import com.easypay.icard.aty.OwnActivity;


public class MainActivity extends TabActivity {

	private TabHost tabHost;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        tabHost=this.getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent=new Intent().setClass(this, IndexActivity.class);
        spec=tabHost.newTabSpec("首页").setIndicator("首页").setContent(intent);
        tabHost.addTab(spec);
        
        intent=new Intent().setClass(this, NearActivity.class);
        spec=tabHost.newTabSpec("附近").setIndicator("附近").setContent(intent);
        tabHost.addTab(spec);
        
        intent=new Intent().setClass(this, BusinessActivity.class);
        spec=tabHost.newTabSpec("店家").setIndicator("店家").setContent(intent);
        tabHost.addTab(spec);
        
     
        intent=new Intent().setClass(this, OwnActivity.class);
        spec=tabHost.newTabSpec("我的").setIndicator("我的").setContent(intent);
        tabHost.addTab(spec);
        tabHost.setCurrentTab(0);
        
        RadioGroup radioGroup=(RadioGroup) this.findViewById(R.id.main_tab_group);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.main_tab_index:
				tabHost.setCurrentTabByTag("首页");
					break;
				case R.id.main_tab_near:
					tabHost.setCurrentTabByTag("附近");
					break;
				case R.id.main_tab_business:
				tabHost.setCurrentTabByTag("店家");
					break;
				case R.id.main_tab_own:
					tabHost.setCurrentTabByTag("我的");
					break;
				default:
					break;
				}
			}
		});
    }

}
