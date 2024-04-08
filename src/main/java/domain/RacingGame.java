package domain;

public class RacingGame {
    private Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void play() {
        cars.race();
    }
}
