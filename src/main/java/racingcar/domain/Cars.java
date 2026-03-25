package racingcar.domain;

import racingcar.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    public void moveAll(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        if (maxPosition == 0) {
            return new ArrayList<>();
        }

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
