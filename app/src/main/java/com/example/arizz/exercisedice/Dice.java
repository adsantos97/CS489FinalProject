package com.example.arizz.exercisedice;

import java.util.Random;

/**
 * Represents a die.
 */
public class Dice {
    private int value;

    /**
     * Constructor.
     */
    public Dice() {
        value = 1;
    }

    /**
     * Gets the value.
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Rolls the dice if it is not locked.
     */
    public void roll() {
        value = new Random().nextInt(6) + 1;
    }
}
