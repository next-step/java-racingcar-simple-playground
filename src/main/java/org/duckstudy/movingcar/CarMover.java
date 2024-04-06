package org.duckstudy.movingcar;

public class CarMover {
    private final RandomValueGenerator randomValueGenerator;

    public CarMover(RandomValueGenerator randomValueGenerator) {
        this.randomValueGenerator = randomValueGenerator;
    }

    public void move(Car car) {
        int randomValue = randomValueGenerator.generateRandomValue();
        if (randomValue >= 4) {
            car.move();
        }
    }
}
