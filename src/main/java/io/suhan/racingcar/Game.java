package io.suhan.racingcar;

import java.util.List;

public class Game {
    private final CarRegistry carRegistry;
    private final int rounds;

    private Game(int rounds) {
        this.carRegistry = CarRegistry.of();
        this.rounds = rounds;
    }

    public static Game of() {
        return new Game(0);
    }

    public static Game of(int rounds) {
        return new Game(rounds);
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
