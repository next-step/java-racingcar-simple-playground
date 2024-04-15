package org.duckstudy.movingcar;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public int move() {
        return ++position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
