package com.lgf.mywanandroid.global;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.lgf.mywanandroid.lgf.global.GlobalApplication;
import com.lgf.mywanandroid.lgf.network.NetWorkManager;

/**
 * Created by Administrator on 2019/5/31 0031.
 * desc :
 */
public class MyApplication extends GlobalApplication {
    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;
    public static MyApplication app;
    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
        //初始化屏幕宽高
        getScreenSize();
        //初始化retrofit2
        NetWorkManager.getInstance().init();

    }


    public void getScreenSize() {
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }
}
