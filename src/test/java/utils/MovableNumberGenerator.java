package utils;

import domain.Car;

public class MovableNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber() {
        return Car.IMMOVABLE_MAX_NUM + 1;
    }
}
