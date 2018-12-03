package com.example.arizz.exercisedice;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ArmsActivity extends Activity {

    // shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    private Dice repsDie;
    private Dice exerciseDie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arms);

        repsDie = new Dice();
        exerciseDie = new Dice();

        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
                handleShakeEvent(count);
            }

        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector,
                mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    /**
     * Rolls and Updates dice images
     * @param count number of times phone shook
     */
    public void handleShakeEvent(int count) {
        // toast
        Toast toast = Toast.makeText(this, "Great Shake!", Toast.LENGTH_LONG);
        toast.show();

        ImageView reps = (ImageView) findViewById(R.id.dice1);
        ImageView exercise = (ImageView) findViewById(R.id.dice2);
        repsDie.roll();
        exerciseDie.roll();
        Log.w("MA", "repsDie: " + repsDie.getValue());
        Log.w("MA", "exerciseDie: " + exerciseDie.getValue());
        updateRepImage(reps);
        updateExerciseImage(exercise);
    }

    /**
     * Updates the image depending on the state of the reps die.
     */
    private void updateRepImage(ImageView v) {
        Log.w("MA", "in method repsDie: " + repsDie.getValue());
        switch (repsDie.getValue()) {
            case 1:
                v.setImageResource(R.drawable.dice4);
                break;
            case 2:
                v.setImageResource(R.drawable.dice6);
                break;
            case 3:
                v.setImageResource(R.drawable.dice8);
                break;
            case 4:
                v.setImageResource(R.drawable.dice10);
                break;
            case 5:
                v.setImageResource(R.drawable.dice12);
                break;
            case 6:
                v.setImageResource(R.drawable.dice14);
                break;
        }
    }

    /**
     * Updates the image depending on the state of the exercise die.
     */
    private void updateExerciseImage(ImageView v) {
        Log.w("MA", "in method exerciseDie: " + exerciseDie.getValue());
        switch (exerciseDie.getValue()) {
            case 1:
                v.setImageResource(R.drawable.arms1);
                break;
            case 2:
                v.setImageResource(R.drawable.arms2);
                break;
            case 3:
                v.setImageResource(R.drawable.arms3);
                break;
            case 4:
                v.setImageResource(R.drawable.arms4);
                break;
            case 5:
                v.setImageResource(R.drawable.arms5);
                break;
            case 6:
                v.setImageResource(R.drawable.arms6);
                break;
        }
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
