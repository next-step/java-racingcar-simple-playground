package io.suhan.racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> cars;
    private GameState state;
    int rounds;

    public Game() {
        this.cars = new ArrayList<>();
        this.state = GameState.IDLE;
        this.rounds = 0;
    }

    public void registerCar(Car car) {
        this.cars.add(car);
    }

    public void start() {
        this.setState(GameState.RUNNING);

        for (int i = 0; i < this.rounds; i++) {
            // TODO: 자동차 이동 구현
        }

        this.setState(GameState.FINISHED);
        List<Car> winners = this.getWinners();

        // TODO: 우승자 출력
    }

    public List<Car> getWinners() {
        if (this.getState() != GameState.FINISHED) {
            throw new IllegalStateException("Winners must be calculated within finish state.");
        }

        int bestPosition = -1;

        for (Car car : cars) {
            int position = car.getPosition();

            if (position > bestPosition) {
                bestPosition = position;
            }
        }

        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == bestPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    public GameState getState() {
        return this.state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
}
