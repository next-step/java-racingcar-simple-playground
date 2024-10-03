package domain.car;

import domain.racegame.MoveStrategy;

public class Car {

    private final CarName carName;
    private final CarPosition carPosition;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.carPosition = new CarPosition();
    }

    public void move(MoveStrategy moveStrategy, int randomNumber) {
        if (moveStrategy.canMove(randomNumber)) {
            carPosition.moveForward();
        }
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getCarPosition() {
        return carPosition.getCarPosition();
    }

}
