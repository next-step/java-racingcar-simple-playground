package domain;

import exception.CarNameTooLongException;

public class Car {
    private final int MOVE_STANDARD_NUMBER = 4;
    private final int MAX_CAR_NAME_LENGTH = 5;
    private String name;
    private int distance = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new CarNameTooLongException("자동차의 이름은 5글자 이하여야합니다.");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 공백이 될 수 없습니다.");
        }
    }

    public void tryMoveByNumber(int number) {
        if (number >= MOVE_STANDARD_NUMBER) {
            move();
        }
    }

    private void move() {
        distance += 1;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
