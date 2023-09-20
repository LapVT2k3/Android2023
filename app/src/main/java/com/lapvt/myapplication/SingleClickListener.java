package com.lapvt.myapplication;

import android.os.SystemClock;
import android.view.View;

public class SingleClickListener implements View.OnClickListener {
    private long mLastClickTime = 0;
    @Override
    public void onClick(View view) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) //*1000 is time to perform second click*
            return; // return when second click happen in second*
        mLastClickTime = SystemClock.elapsedRealtime();
    }
}
