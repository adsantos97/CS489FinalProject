package com.example.arizz.exercisedice;

import android.app.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
// import android.widget.LinearLayout;

// import com.google.android.gms.ads.*;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

public class StatsActivity extends Activity {
    private PublisherAdView mPublisherAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
/*
        // advertisement
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.SMART_BANNER);
        String adUnitId ="ca-app-pub-3940256099942544/6300978111";
        adView.setAdUnitId(adUnitId);
*/
        /** target data */
/*
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.addKeyword("workout");
        builder.addKeyword("fitness").addKeyword("sport");

        AdRequest request = builder.build();
        builder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        // Use AdRequest.Builder.addTestDevice(-------) in logcat if testing on device

        LinearLayout ll = (LinearLayout) findViewById(R.id.ad_view);
        ll.addView(adView);

        adView.loadAd(request);

        */
        update();

        // banner ad
        mPublisherAdView = findViewById(R.id.publisherAdView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        // add .addTestDevice("") if want to test on device
        // search Use AdRequest.Builder in logcat
        mPublisherAdView.loadAd(adRequest);
    }

    /**
     * Update the TextViews to display persistent data
     */
    public void update() {
        Exercise ex = MainActivity.ex;

        TextView highestScore = (TextView) findViewById(R.id.highest_score);
        TextView currentScore = (TextView) findViewById(R.id.current_score);

        int current = ex.getCurrentExercises();
        Log.w("MA", "current: " + current);
        int highest = ex.getHighestExercises();
        Log.w("MA", "highest: " + highest);

        highestScore.setText("" + highest);
        currentScore.setText(""+ current);
    }

    /**
     * When the Back button gets clicked
     * @param v the view
     */
    public void goBack(View v) {
        this.finish();
        overridePendingTransition(R.anim.slide_from_right, 0);
    }
}
