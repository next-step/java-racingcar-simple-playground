package racingCar.domain;

import racingCar.NumberGenerator;

public class Car {

    public final String name;
    public int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= 4) {
            position += 1;
        }
    }
}
