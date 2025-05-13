package racingcar.domain;

import racingcar.domain.vo.Winners;
import racingcar.util.RandomNumberGenerator;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(final Cars cars, final RandomNumberGenerator randomNumberGenerator) {
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void moveCars() {
        cars.moveCars(randomNumberGenerator);
    }

    public Winners getWinners() {
        return cars.findWinners();
    }

    public List<Car> getCars() {
        return cars.value();
    }
}
