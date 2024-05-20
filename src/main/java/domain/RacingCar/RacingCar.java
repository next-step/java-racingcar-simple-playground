package domain.RacingCar;

import static util.Constants.LOWER_BOUND_OF_MOVE;
import static util.Constants.START_LOCATION;

public class RacingCar {

    private final String name;
    private int location;

    public RacingCar(String name) {
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

}

