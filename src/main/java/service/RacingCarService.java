package service;

import domain.Car.RacingCar;

public class RacingCarService {

    public void race(RacingCar racingCar, int randomNumber) {
        if (isMove(randomNumber)) {
            racingCar.move();
        }
    }

    public int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

    private boolean isMove(int randomNumber) {
        return randomNumber >= 4;
    }
}
