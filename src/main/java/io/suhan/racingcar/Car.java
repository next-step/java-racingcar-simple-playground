package io.suhan.racingcar;

import io.suhan.racingcar.generator.NumberGenerator;
import io.suhan.racingcar.generator.RandomNumberGenerator;

public class Car {
    private static final int CAR_MOVE_THRESHOLD = 4;

    private final String name;
    private final NumberGenerator generator;
    private int position;

    public Car(String name) {
        this.name = name;
        this.generator = new RandomNumberGenerator();
        this.position = 0;
    }

    public Car(String name, NumberGenerator generator) {
        this.name = name;
        this.generator = generator;
        this.position = 0;
    }

    public void move() {
        int number = this.generator.generate();

        if (number >= CAR_MOVE_THRESHOLD) {
            this.incrementPosition();
        }
    }

    private void incrementPosition() {
        this.position += 1;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
