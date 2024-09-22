package domain;

import util.GoOrStopValidator;
import util.RandomValueCreator;

public class Car {

    private String carName;
    private int currentDistance;
    private String currentDistanceMark;

    public Car(String carName, int currentDistance) {
        this.carName = carName;
        this.currentDistance = currentDistance;
        this.currentDistanceMark = "-";
    }

    public void ride() {
        if (isGoOrStop(createRandomValue())) {
            this.currentDistance += 1;
            this.currentDistanceMark += "-";
        }
    }

    // Q : 아래 두 함수도 따로 클래스를 분리하는 것이 좋은 것인지...?
    private int createRandomValue() {
        return RandomValueCreator.createRandomValue();
    }

    private boolean isGoOrStop(final int randomValue) {
        return GoOrStopValidator.validateGoOrStop(randomValue);
    }

    public int getCurrentDistance() {
        return this.currentDistance;
    }

    public String getCarName() {
        return carName;
    }

    public String getCurrentDistanceMark() {
        return currentDistanceMark;
    }
}
