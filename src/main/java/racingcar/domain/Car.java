package racingcar.domain;

import racingcar.exception.InputErrorCode;
import racingcar.exception.InvalidInputException;

public class Car {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MOVE_DISTANCE = 1;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position += MOVE_DISTANCE;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException(InputErrorCode.CAR_NAME_BLANK);
        }
        if (name.trim().length() > MAX_CAR_NAME_LENGTH) {
            throw new InvalidInputException(InputErrorCode.CAR_NAME_TOO_LONG);
        }
    }
}
