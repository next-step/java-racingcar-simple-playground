package domain;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int INITIAL_LOCATION = 0;

    private final List<Car> cars;

    private List<Car> createCars(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .map(name -> new Car(name, INITIAL_LOCATION))
                .toList();
    }

    public RacingGame(String carNames) {
        cars = createCars(carNames);
    }

    public void race(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.moveCar(numberGenerator.getNumber());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> findWinners() {
        return new WinnerFinder().findWinners(cars);
    }
}
