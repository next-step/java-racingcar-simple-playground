package model;

import components.NumberGenerator;
import components.RandomNumberGenerator;
import constants.ErrorMessage;

public class Car {
    private int distance = 0;
    private final String name;
    private final NumberGenerator numberGenerator;

    public Car(String name) {
        this.checkCarNameIsLessThanSix(name);
        this.name = name;
        this.numberGenerator = new RandomNumberGenerator();
    }

    public Car(String name, NumberGenerator numberGenerator) {
        this.checkCarNameIsLessThanSix(name);
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    private void checkCarNameIsLessThanSix(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_TOO_LONG);
        }
    }

    public void move() {
        boolean canMove = numberGenerator.generateNumber() >= 4;
        if (canMove) {
            distance += 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}
