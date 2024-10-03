package domain.racegame;

import domain.car.Cars;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final int raceCount;
    private int currentRound = 0;

    public RacingGame(Cars cars, int raceCount) {
        this.cars = cars;

        if (raceCount < 1) {
            throw new IllegalArgumentException("레이스 횟수는 1회 이상이어야 합니다.");
        }

        this.raceCount = raceCount;
    }

    public void playOneRoundRace(MoveStrategy moveStrategy) {
        cars.raceOneRound(moveStrategy);
        currentRound++;
    }

    public boolean isRaceOngoing() {
        return currentRound < raceCount;
    }

    public List<String> getWinners() {
        return cars.findWinners();
    }

}
