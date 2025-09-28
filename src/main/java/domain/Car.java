package domain;

import util.GenerateNumber;

public class Car {
    private static final int STANDARD = 4;

    private final CarName carName;
    private int carPosition;

    private Car(CarName carName) {
        this.carName = carName;
        this.carPosition = 0;
    }

    public static Car createCarByCarName(CarName carName) {
        return new Car(carName);
    }

    public void moveCar() {
        int randomNumber = GenerateNumber.generateNumber();
        if (randomNumber >= STANDARD) {
            carPosition++;
        }
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getCarPosition() {
        return carPosition;
    }
}
