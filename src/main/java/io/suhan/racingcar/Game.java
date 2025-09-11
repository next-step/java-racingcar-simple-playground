package io.suhan.racingcar;

import java.util.List;

public class Game {
    private final CarRegistry carRegistry;
    private int rounds;

    public Game() {
        this.carRegistry = new CarRegistry();
        this.rounds = 0;
    }

    public void start() {
        for (int i = 0; i < this.rounds; i++) {
            carRegistry.moveCars();
        }
        // TODO: 우승자 출력
    }

    public List<Car> getWinners() {
        int bestPosition = getBestPosition();

        return carRegistry.getRegisteredCars()
                .stream()
                .filter((car) -> car.getPosition() == bestPosition)
                .toList();
    }

    public void setTrialRoundsCount(int rounds) {
        this.rounds = rounds;
    }

    private int getBestPosition() {
        return carRegistry.getRegisteredCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }

    public CarRegistry getCarRegistry() {
        return carRegistry;
    }
}
