package domain;

import java.util.Random;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final Random RANDOM = new Random();

    private final String name;
    private int location;

    public Car(String carName) {
        validateNameLength(carName);
        this.name = carName;
    }

    void move() {
        moveCar(createRandomNumber());
    }

    void moveCar(int number) {
        if (number >= 4) {
            location += 1;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private int createRandomNumber() {
        return RANDOM.nextInt(10);
    }
}
