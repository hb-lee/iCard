/**
 * 
 */
package com.easypay.icard;

import android.app.Application;

import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;

/**
 * @author Bruce
 *
 */
public class MyApp extends Application {
	public LocationClient mLocClient;
    @Override
    public void onCreate() {
        super.onCreate();
            //初始化百度地图
        SDKInitializer.initialize(getApplicationContext());
    }
}
