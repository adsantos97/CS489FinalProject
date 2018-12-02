package com.example.arizz.exercisedice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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
     * When Button1 is clicked
     * @param v the view
     */
    public void toViewTwo(View v) {
        /** Create an intent to start a new activity */
        Intent v2 = new Intent(this, Main2Activity.class);
        this.startActivity(v2);
        overridePendingTransition(R.anim.slide_from_left, 0);
    }
}
