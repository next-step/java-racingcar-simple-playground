package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final int lapCount;
    private final List<Car> racingCars;

    public RacingGame(List<Car> racingCars, int lapCount) {
        this.racingCars = racingCars;
        this.lapCount = lapCount;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public int getLapCount() {
        return lapCount;
    }

    public List<Car> startLap() {
        for (Car racingCar : racingCars) {
            racingCar.moveCar(RandomNumGenerator.makeNum());
        }
        return racingCars;
    }

}
