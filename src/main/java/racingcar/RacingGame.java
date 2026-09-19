package racingcar;

public class RacingGame {
    private final Cars cars;
    private final RandomNumber randomNumber;
    private final int raceCount;

    public RacingGame(Cars cars, RandomNumber randomNumber, int raceCount) {
        this.cars = cars;
        this.randomNumber = randomNumber;
        this.raceCount = raceCount;
    }

    public void carRace() {
        for (int i = 0; i < raceCount; i++) {
            cars.move(randomNumber);
        }
    }
}
