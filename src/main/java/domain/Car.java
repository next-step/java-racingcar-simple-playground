package domain;

import utils.NumberGenerator;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private int distance;

    public static final int MOVING_PACE = 1;
    public static final int IMMOVABLE_MAX_NUM = 3;

    public Car(CarName carName) {
        this.carName = carName;
        distance = 0;
    }

    public void move(NumberGenerator numberGenerator) {
        if (isMovable(numberGenerator.generateNumber())) {
            distance += MOVING_PACE;
        }
    }

    private boolean isMovable(int number) {
        return number > IMMOVABLE_MAX_NUM;
    }

    public String getName() {
        return carName.getName();
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
