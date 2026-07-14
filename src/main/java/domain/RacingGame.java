package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int INITIAL_LOCATION = 0;

    private final List<Car> cars;

    public RacingGame(String carNames) {
        cars = createCars(carNames);
    }

    public List<List<Car>> race(int trialNumber, NumberGenerator numberGenerator) {
        List<List<Car>> raceResults = new ArrayList<>();

        for (int count = 0; count < trialNumber; count++) {
            moveCars(numberGenerator);
            raceResults.add(getCars());
        }

        return raceResults;
    }

    public List<Car> getCars() {
        return copyCars(cars);
    }

    public List<String> findWinners() {
        return new WinnerFinder().findWinners(cars);
    }

    private void moveCars(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.moveCar(numberGenerator.getNumber());
        }
    }

    private List<Car> createCars(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .map(name -> new Car(name, INITIAL_LOCATION))
                .toList();
    }

    private List<Car> copyCars(List<Car> cars) {
        return cars.stream()
                .map(car -> new Car(car.getName(), car.getLocation()))
                .toList();
    }
}
