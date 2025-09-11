package io.suhan.racingcar;

import java.util.Random;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int number = this.generateNumber();
        if (number >= 4) {
            this.incrementPosition();
        }
    }

    private void incrementPosition() {
        this.position += 1;
    }

    private int generateNumber() {
        Random random = new Random();

        return random.nextInt(10);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
