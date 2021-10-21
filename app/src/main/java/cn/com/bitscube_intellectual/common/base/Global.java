package cn.com.bitscube_intellectual.common.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 封装全局的上下文、Handler异步消息的处理等。
 * Created by Emily on 9/6/21
 */
public class Global {
    public static Context mContext;

    public static float mDensity;

    public static float mScreenWidth;

    public static float mScreenHeight;
    private static View mStatusBarView;

    public static void init(Context context) {
        mContext = context;
        initScreenSize();
    }

    private static void initScreenSize() {
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        mDensity = dm.density;
        mScreenHeight = dm.heightPixels;
        mScreenWidth = dm.widthPixels;
    }

    public static int dp2px(int dp) {
        return (int) (dp * mDensity);
    }

    public static View inflate(int layoutResID, ViewGroup parent) {
        return LayoutInflater.from(mContext).inflate(layoutResID, parent, false);
    }

    public static View inflate(int layoutResID) {
        return inflate(layoutResID, null);
    }

    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    public static Handler getMainHandler() {
        return mHandler;
    }


    public static boolean isUIThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void runOnUIThread(Runnable run) {
        if (isUIThread()) {
            run.run();
        } else {
            mHandler.post(run);
        }
    }
}


