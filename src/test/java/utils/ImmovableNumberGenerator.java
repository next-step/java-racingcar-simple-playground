package utils;

import domain.Car;

public class ImmovableNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber() {
        return Car.IMMOVABLE_MAX_NUM;
    }
}
