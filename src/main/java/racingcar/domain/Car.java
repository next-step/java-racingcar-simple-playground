package racingcar.domain;

import racingcar.RandomNumberGenerator;

public class Car {

    private static final int ACCELERATION = 4;

    private final String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(RandomNumberGenerator generator) {
        if (generator.generate() >= ACCELERATION) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
