package org.duckstudy.movingcar;

import java.util.List;

public class CarMover {

    private static final int MIN_MOVEMENT_VALUE = 4;
    private final RandomValueGenerator randomValueGenerator;

    public CarMover(RandomValueGenerator randomValueGenerator) {
        this.randomValueGenerator = randomValueGenerator;
    }

    void move(Car car) {
        int randomValue = randomValueGenerator.generateRandomValue();
        if (randomValue >= MIN_MOVEMENT_VALUE) {
            car.move();
        }
    }

    public void move(List<Car> carList) {
        for (Car car : carList) {
            this.move(car);
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
