package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<String> carNames;
    private final List<Car> racingGameCars;

    public RacingCars(List<String> carNames) {
        this.carNames = carNames;
        this.racingGameCars = new ArrayList<>();
        makeRacingCars();
    }

    private void makeRacingCars() {
        for (String racingCarNames : carNames) {
            racingGameCars.add(new Car(racingCarNames));
        }
    }

    public List<Car> getCarsList() {
        return racingGameCars;
    }
}
