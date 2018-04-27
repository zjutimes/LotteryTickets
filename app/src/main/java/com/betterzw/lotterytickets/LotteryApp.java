package com.betterzw.lotterytickets;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by zhengwu on 4/10/18.
 */
public class LotteryApp extends Application{

    private static LotteryApp INSTANCE;

    public LotteryApp(){
        INSTANCE = this;
    }

    public static LotteryApp getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
