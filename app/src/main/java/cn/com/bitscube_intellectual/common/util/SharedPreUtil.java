package cn.com.bitscube_intellectual.common.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 数据存储工具类
 * Created by Emily on 9/9/21
 */
public class SharedPreUtil {
    //文件名
    private static final String CONFIG_FILE_NAME = "config";

    public static String getString(Context context, String key, String defValue) {
        // file name .xml
        SharedPreferences sp = context.getSharedPreferences(CONFIG_FILE_NAME,
                Context.MODE_PRIVATE);//避免文件篡改
        return sp.getString(key, defValue);
    }

    public static void saveString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(CONFIG_FILE_NAME, Context
                .MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = context.getSharedPreferences(
                CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static void saveBoolean(Context context, String key, Boolean value) {
        SharedPreferences sp = context.getSharedPreferences(//
                CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences(CONFIG_FILE_NAME, Context
                .MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    public static void saveInt(Context context, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(
                CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static Long getLong(Context context, String key, Long defValue) {
        SharedPreferences sp = context.getSharedPreferences(
                CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getLong(key, defValue);
    }

    public static void saveLong(Context context, String key, Long value) {
        SharedPreferences sp = context.getSharedPreferences(
                CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.apply();
    }
}

