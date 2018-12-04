package com.example.arizz.exercisedice;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Exercise {

    private static final String PREFERENCE_MOOD = "mood";

    private float mood;

    /**
     * Constructor
     * @param context the context
     */
    public Exercise(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        setMood(pref.getFloat(PREFERENCE_MOOD, 0.0f));
    }

    /**
     * Set the data into Shared Preferences
     * @param context the context
     */
    public void setPreferences(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putFloat(PREFERENCE_MOOD, mood);
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
}
