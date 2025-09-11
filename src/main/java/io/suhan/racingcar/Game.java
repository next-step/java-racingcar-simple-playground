package io.suhan.racingcar;

import java.util.List;

public class Game {
    private final CarRegistry carRegistry;
    private final int rounds;

    public Game() {
        this.carRegistry = new CarRegistry();
        this.rounds = 0;
    }

    public Game(int rounds) {
        this.carRegistry = new CarRegistry();
        this.rounds = rounds;
    }

    public void start() {
        for (int i = 0; i < this.rounds; i++) {
            carRegistry.moveCars();
        }
        // TODO: 우승자 출력
    }

    public List<Car> getWinners() {
        int bestPosition = carRegistry.getBestPosition();

        return carRegistry.getRegisteredCars()
                .stream()
                .filter((car) -> car.getPosition() == bestPosition)
                .toList();
    }

    public CarRegistry getCarRegistry() {
        return carRegistry;
    }
}
