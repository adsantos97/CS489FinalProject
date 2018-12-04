package com.example.arizz.exercisedice;

import android.app.Activity;

import android.os.Bundle;
import android.widget.RatingBar;

public class StatsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        displayYesterdayMood();
    }

    public void displayYesterdayMood() {
        Exercise ex = MainActivity.ex;
        RatingBar yesterdayMood = (RatingBar) findViewById(R.id.yesterday_mood);
        yesterdayMood.setRating((float) ex.getYesterdayMood());
    }
}
