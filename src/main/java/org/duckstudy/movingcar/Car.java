package org.duckstudy.movingcar;

public class Car {

    private final String name;
    private long position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public long move() {
        return ++position;
    }

    public void reset() {
        this.position = 0;
    }
}
