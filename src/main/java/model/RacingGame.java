package model;

public class RacingGame {

    private final Cars cars;
    private final RandomUtil randomUtil;

    public RacingGame(Cars cars, RandomUtil randomUtil) {
        this.cars = cars;
        this.randomUtil = randomUtil;
    }

    public void race() {
        for (Car car : cars.getCars()) {
            int randomNum = randomUtil.generateRandomNumber();
            car.move(randomNum);
        }
    }
}