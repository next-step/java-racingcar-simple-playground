package domain;

public class RacingGame {
    private final Cars cars;
    private final RandomNumber randomNumber;

    public RacingGame(Cars cars, RandomNumber randomNumber) {
        this.cars = cars;
        this.randomNumber = randomNumber;
    }

    public void carRaceOnce() {
        cars.move(randomNumber);
    }


}
