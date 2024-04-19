package domain;

import exception.CarException;
import exception.ErrorMessage;
import utils.ValueGenerator;

public class Car {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;
    private int distance;
    private final ValueGenerator generator;

    public Car(final String name, final ValueGenerator generator) {
        validateCar(name);
        this.name = name;
        this.distance = 0;
        this.generator = generator;
    }

    private void validateCar(final String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH ) {
            throw new CarException(
                    ErrorMessage.NAME_LENGTH_INCORRECT.formatMessage(MIN_LENGTH,MAX_LENGTH));
        }
    }

    public void moveOrStop() {
        int value = generator.generate();
        if (isMove(value)) {
            move();
        }
    }

    private void move() {
        this.distance++;
    }

    private boolean isMove(final int value) {
        return value >= 4 && value <= 9;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

}
