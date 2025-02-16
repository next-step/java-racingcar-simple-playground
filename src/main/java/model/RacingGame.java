package model;

public class RacingGame {

    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void race() {
        for (Car car : cars.getCars()) {
            int randomNum = RandomValueGenerator.getRandomNumber();
            car.move(randomNum);
        }
    }
}