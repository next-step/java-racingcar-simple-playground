package io.suhan.racingcar;

import java.util.Random;

public class Car {
    private static final int CAR_MOVE_THRESHOLD = 4;
    private static final int RANDOM_BOUND = 10;


    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int number = this.generateNumber();
        if (number >= CAR_MOVE_THRESHOLD) {
            this.incrementPosition();
        }
    }

    private void incrementPosition() {
        this.position += 1;
    }

    private int generateNumber() {
        Random random = new Random();

        return random.nextInt(RANDOM_BOUND);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
