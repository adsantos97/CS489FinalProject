package com.example.arizz.exercisedice;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Exercise {

    private static final String PREFERENCE_MOOD = "mood";
    private static final String PREFERENCE_HIGHEST = "highest";
    private static final String PREFERENCE_CURRENT = "current";

    private float mood;
    private int highestExercises;
    private int currentExercises;

    /**
     * Constructor
     * @param context the context
     */
    public Exercise(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        setMood(pref.getFloat(PREFERENCE_MOOD, 0.0f));
        setHighestExercises(pref.getInt(PREFERENCE_HIGHEST, 0));
        setCurrentExercises(pref.getInt(PREFERENCE_CURRENT, 0));
    }

    /**
     * Set the data into Shared Preferences
     * @param context the context
     */
    public void setPreferences(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putFloat(PREFERENCE_MOOD, mood);
        editor.putInt(PREFERENCE_HIGHEST, highestExercises);
        editor.putInt(PREFERENCE_CURRENT, currentExercises);
        editor.commit();
    }

    /**
     * Getter for mood
     * @return the mood
     */
    public float getMood() {
        return mood;
    }

    /**
     * Set mood
     * @param newMood the new mood
     */
    public void setMood(float newMood) {
        mood = newMood;
    }


    /**
     * Set for highest number of exercises achieved
     * @param newHighests
     */
    public void setHighestExercises(int newHighests) {
        if (newHighests > highestExercises) {
            highestExercises = newHighests;
        }
    }

    /**
     * Getter for highest number of exercises achieved
     * @return
     */
    public int getHighestExercises() {
        return highestExercises;
    }

    public void setCurrentExercises(int newExercises) {
        currentExercises = newExercises;
    }

    public int getCurrentExercises() {
        return currentExercises;
    }
}
