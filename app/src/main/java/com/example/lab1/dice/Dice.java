package com.example.lab1.dice;

import java.util.Random;

public class Dice {

    private final int sides;

    private final Random random = new Random();

    private Dice(int sides) {
        this.sides = sides;
    }

    public static Dice of(int sides) {
        return new Dice(sides);
    }

    public String roll() {
        return String.valueOf(random.nextInt(sides + 1));
    }
}
