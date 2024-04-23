package org.duckstudy.model.car;

import org.duckstudy.model.generator.RandomValueGenerator;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int INITIAL_POSITION = 0;
    private static final int MIN_MOVEMENT_VALUE = 4;

    private final String name;
    private final RandomValueGenerator randomValueGenerator;
    private int position;

    public Car(String name, RandomValueGenerator randomValueGenerator) {
        validateCarName(name);

        this.name = name;
        this.randomValueGenerator = randomValueGenerator;
        this.position = INITIAL_POSITION;
    }

    private void validateCarName(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름은 1글자 이상 %d글자 이하만 가능합니다.\n", MAX_NAME_LENGTH));
        }
    }

    public void move() {
        int randomValue = randomValueGenerator.generateRandomValue();
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
