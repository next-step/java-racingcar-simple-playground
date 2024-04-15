package org.duckstudy.movingcar;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
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
