package racingcar.domain;

import racingcar.generator.NumberGenerator;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final NumberGenerator numberGenerator;

    public RacingGame(Cars cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void playRound() {
        cars.moveAll(numberGenerator);
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
