package com.example.arizz.exercisedice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;

public class MainActivity extends Activity {

    public static Exercise ex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ex = new Exercise(this);
        setContentView(R.layout.activity_main);
        ex.setUpdateClicked(false);
    }

    @Override
    protected void onStop() {
        super.onStop();
        ex.setYesterdayMood(ex.getMood());
        ex.setPreferences(this);
    }

    /**
     * Updates the rating bar
     * Uses persistent data
     * @param v the view
     */
    public void updateMood(View v) {
        ex.setUpdateClicked(true);
        RatingBar todayMood = (RatingBar) findViewById(R.id.today_mood);
        float moodNum = todayMood.getRating();
        Log.w("MA", "moodNum: " + moodNum);
        ex.setMood(moodNum);
        // set persistent data
        ex.setPreferences(this);
    }

    /**
     * Go to the Arms view
     * @param v the view
     */
    public void toArms(View v) {
        /** Create an intent to start a new activity */
        Intent intent = new Intent(this, ArmsActivity.class);
        this.startActivity(intent);
        overridePendingTransition(R.anim.slide_from_left, 0);
    }

    /**
     * Go to the Legs view
     * @param v the view
     */
    public void toLegs(View v) {
        /** Create an intent to start a new activity */
        Intent intent = new Intent(this, LegsActivity.class);
        this.startActivity(intent);
        overridePendingTransition(R.anim.slide_from_left, 0);
    }

    /**
     * Go to the Core view
     * @param v the view
     */
    public void toCore(View v) {
        /** Create an intent to start a new activity */
        Intent intent = new Intent(this, CoreActivity.class);
        this.startActivity(intent);
        overridePendingTransition(R.anim.slide_from_left, 0);
    }

    /**
     * Go to the Cardio view
     * @param v the view
     */
    public void toCardio(View v) {
        /** Create an intent to start a new activity */
        Intent intent = new Intent(this, CardioActivity.class);
        this.startActivity(intent);
        overridePendingTransition(R.anim.slide_from_left, 0);
    }

    /**
     * Go to the Stats view
     * @param v the view
     */
    public void toStats(View v) {

        /** Create an intent to start a new activity */
        Intent intent = new Intent(this, StatsActivity.class);
        this.startActivity(intent);
        overridePendingTransition(R.anim.slide_from_left, 0);
    }
}
