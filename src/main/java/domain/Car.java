package domain;

import util.GoOrStopValidator;
import util.RandomValueCreator;

public class Car {

    private String carName;
    private int currentDistance;

    public Car(String carName, int currentDistance) {
        this.carName = carName;
        this.currentDistance = currentDistance;
    }

    public int getCurrentDistance() {
        return this.currentDistance;
    }

    public String getCarName() {
        return carName;
    }

    public void goForward() {
        this.currentDistance += 1;
    }
}
