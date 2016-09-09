/**
 * 
 */
package com.easypay.icard.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Bruce
 *
 */
public class SPUtils {
	private static SharedPreferences sharedPreferences;

    // 存double(上下文,key,value)
    public static void putString(Context context, String key, String value) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putString(key, value).commit();
    }

    // 取
    public static String getString(Context context, String key, String defValue) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        return sharedPreferences.getString(key, defValue);
    }
}
