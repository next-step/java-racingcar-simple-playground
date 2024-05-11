package model;

import controller.RandomNumberGenerator;

import java.util.ArrayList;

public class Car {
    private final String name;
    private int distance;
    private final RandomNumberGenerator numberGenerator;

    public Car(String name, int distance, RandomNumberGenerator numberGenerator) {
        validateName(name);
        this.name = name;
        this.distance = distance;
        this.numberGenerator = numberGenerator;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이상일 수 없습니다.");
        }
    }

    public int moving() {
        if (numberGenerator.createRandomNumber() >= 4) {
            distance++;
        }
        return distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}