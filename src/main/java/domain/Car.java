package domain;

import exception.CarNameRequiredException;
import exception.CarNameTooLongException;
import util.NumberProvider;

public class Car {

    private final static int MOVE_CONDITION = 4;
    private final static int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new CarNameRequiredException("자동차 이름은 필수입니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new CarNameTooLongException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void move(NumberProvider numberProvider) {
        int randomNumber = numberProvider.provide();
        if (isMovable(randomNumber)) {
            position++;
        }
    }

    private boolean isMovable(int randomValue) {
        return randomValue >= MOVE_CONDITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
