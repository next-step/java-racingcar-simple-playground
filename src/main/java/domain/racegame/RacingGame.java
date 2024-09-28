package domain.racegame;

import domain.car.Cars;

public class RacingGame {

    private final Cars cars;
    private final int raceCount;
    private int currentRound = 0;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final MoveStrategy moveStrategy = new RandomMoveStrategy();

    public RacingGame(Cars cars, int raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public void playOneRoundRace() {
        cars.raceOneRound(moveStrategy, randomNumberGenerator);
        currentRound++;
    }

    public boolean isRaceOngoing() {
        return currentRound < raceCount;
    }

    public String getWinners() {
        return String.join(",", cars.findWinners());
    }

}
