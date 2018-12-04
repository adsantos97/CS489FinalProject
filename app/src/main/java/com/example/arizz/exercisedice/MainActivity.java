package com.example.arizz.exercisedice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static Exercise ex;
    public RatingBar mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ex = new Exercise(this);
        setContentView(R.layout.activity_main);

        mood = (RatingBar) findViewById(R.id.mood);
        mood.setRating((float) ex.getMood());
    }

    /**
     * Store new mood for next time
     * Uses persistent data
     * @param v the view
     */
    public void updateMood(View v) {
        float moodNum = mood.getRating();

        if(moodNum <= 1.0) {
            Toast toast = Toast.makeText(this, "Awfully Tired.", Toast.LENGTH_LONG);
            toast.show();
        } else if(moodNum > 1.0 && moodNum <= 2.0) {
            Toast toast = Toast.makeText(this, "Tired.", Toast.LENGTH_LONG);
            toast.show();
        } else if(moodNum > 2.0 && moodNum <= 3.0) {
            Toast toast = Toast.makeText(this, "Feelin' Meh.", Toast.LENGTH_LONG);
            toast.show();
        } else if(moodNum > 3.0 && moodNum <= 4.0) {
            Toast toast = Toast.makeText(this, "Feelin' Great!", Toast.LENGTH_LONG);
            toast.show();
        } else if(moodNum > 4.0 && moodNum <= 5.0) {
            Toast toast = Toast.makeText(this, "Energized!", Toast.LENGTH_LONG);
            toast.show();
        }

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
