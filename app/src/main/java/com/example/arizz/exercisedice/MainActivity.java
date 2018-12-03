package com.example.arizz.exercisedice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    public static Exercise ex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
