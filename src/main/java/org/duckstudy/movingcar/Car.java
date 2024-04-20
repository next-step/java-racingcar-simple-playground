package org.duckstudy.movingcar;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int MIN_MOVEMENT_VALUE = 4;
    private final RandomValueGenerator randomValueGenerator;
    private final String name;
    private int position;

    public Car(RandomValueGenerator randomValueGenerator, String name) {
        this.randomValueGenerator = randomValueGenerator;
        this.name = name;
        this.position = INITIAL_POSITION;
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
