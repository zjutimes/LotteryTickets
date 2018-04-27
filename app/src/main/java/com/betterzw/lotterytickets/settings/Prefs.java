package com.betterzw.lotterytickets.settings;


import com.betterzw.lotterytickets.R;

import static com.betterzw.lotterytickets.settings.PrefsIoUtil.getBoolean;

/**
 * Created by zhengwu on 4/10/18.
 */
public class Prefs {
    public static boolean isSplashEnabled() {
        return getBoolean(R.string.preference_key_splash_enabled, false);
    }
}
