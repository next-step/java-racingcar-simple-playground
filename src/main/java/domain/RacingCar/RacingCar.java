package domain.RacingCar;

import java.util.List;
import java.util.Map;
import util.Errors;

public class RacingCar {

    private static final int START_LOCATION = 0;
    private static final int LOWER_BOUND_OF_MOVE = 4;
    private static final int MAX_LENGTH_OF_RACING_CAR_NAME = 5;

    private final String name;
    private int location;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
        this.location = START_LOCATION;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void race(int randomNumber) {
        if (isMove(randomNumber)) {
            this.location++;
        }
    }

    private boolean isMove(int randomNumber) {
        return randomNumber >= LOWER_BOUND_OF_MOVE;
    }

    private void validateName(String name) {
        if (name.length() > MAX_LENGTH_OF_RACING_CAR_NAME) {
            throw new IllegalArgumentException(Errors.getLengthOfCarNameError(name, MAX_LENGTH_OF_RACING_CAR_NAME));
        }
    }
}

