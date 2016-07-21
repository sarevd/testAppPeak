package com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.peak.PeakSdk;
import com.peak.PeakSdkUiHelper;

public class MainActivity extends AppCompatActivity {

    PeakSdkUiHelper uiHelper = new PeakSdkUiHelper(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PeakSdk.initialize("5b1656281bbad6b8", uiHelper, null);

        boolean isAdAvailable = PeakSdk.checkAdAvailable("27022");
        Log.d("peakint", isAdAvailable + "");

        if (isAdAvailable) {
            PeakSdk.showInterstitial("27022");
        }

        RelativeLayout layout = new RelativeLayout(this);

        boolean isAdBannerAvailable = PeakSdk.checkAdAvailable("27041");
        Log.d("peakb", isAdBannerAvailable + "");
        if (isAdBannerAvailable) {
            View banner = PeakSdk.showBanner("27041");
            if (banner != null) {
                layout.addView(banner);
            }
        }


    }

    @Override
    protected void onPause() {
        uiHelper.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        uiHelper.resume();
    }

    @Override
    protected void onDestroy() {
        uiHelper.destroy();
        super.onDestroy();
    }
}
