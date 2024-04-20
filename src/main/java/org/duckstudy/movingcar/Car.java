package org.duckstudy.movingcar;

import org.duckstudy.generator.Generator;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int MIN_MOVEMENT_VALUE = 4;
    private final String name;
    private final Generator generator;
    private int position;

    public Car(String name, Generator generator) {
        this.name = name;
        this.generator = generator;
        this.position = INITIAL_POSITION;
    }

    public void move() {
        int randomValue = generator.generateValue();
        if (randomValue >= MIN_MOVEMENT_VALUE) {
            ++position;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
