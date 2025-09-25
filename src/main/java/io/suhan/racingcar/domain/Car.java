package io.suhan.racingcar.domain;

import io.suhan.racingcar.generator.NumberGenerator;
import io.suhan.racingcar.generator.RandomNumberGenerator;

public class Car {
    public static final int CAR_MOVE_THRESHOLD = 4;
    public static final int CAR_NAME_MAXIMUM_LENGTH = 5;

    private final String name;
    private final NumberGenerator generator;
    private int position;

    private Car(String name, NumberGenerator generator) {
        this.name = name;
        this.generator = generator;
        this.position = 0;
    }

    public static Car of(String name) {
        return Car.of(name, new RandomNumberGenerator());
    }

    public static Car of(String name, NumberGenerator generator) {
        if (name.length() > CAR_NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 " + CAR_NAME_MAXIMUM_LENGTH + "자 이하만 가능합니다.");
        }

        return new Car(name, generator);
    }

    public void move() {
        int number = generator.generate();

        if (number >= CAR_MOVE_THRESHOLD) {
            incrementPosition();
        }
    }

    private void incrementPosition() {
        position += 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car copy() {
        Car copy = Car.of(this.name, this.generator);
        copy.position = this.position;

        return copy;
    }
}
