package racingCar.domain;

import racingCar.NumberGenerator;

public class Car {

    private final String name;
    private int position = 0;
    private NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public void move() {
        if (numberGenerator.generate() >= 4) {
            position += 1;
        }
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }
}
