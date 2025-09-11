package io.suhan.racingcar;

import java.util.ArrayList;
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
            // TODO: 자동차 이동 구현
        }

        List<Car> winners = this.getWinners();

        // TODO: 우승자 출력
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();

        int bestPosition = this.getBestPosition();

        for (Car car : carRegistry.getRegisteredCars()) {
            if (car.getPosition() == bestPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    public void setTrialRoundsCount(int rounds) {
        this.rounds = rounds;
    }

    private int getBestPosition() {
        int bestPosition = -1;

        for (Car car : carRegistry.getRegisteredCars()) {
            int position = car.getPosition();

            if (position > bestPosition) {
                bestPosition = position;
            }
        }

        return bestPosition;
    }
}
