package model;

import controller.RandomNumberGenerator;

public class Car {
    private String name;
    private int distance;
    private RandomNumberGenerator numberGenerator;

    public Car(String name, int distance, RandomNumberGenerator numberGenerator) {
        this.name = name;
        this.distance = distance;
        this.numberGenerator = numberGenerator;
    }

    /**
     랜덤 생성해서 필드값 움직여줌
     */
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