package org.duckstudy.model.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.duckstudy.model.generator.RandomValueGenerator;

public class Cars {

    private static final int INITIAL_POSITION = 0;
    public static final int EXCLUSIVE_MIN_REPETITION_NUM = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public Cars(String[] carNames, RandomValueGenerator randomValueGenerator) {
        this(Arrays.stream(carNames)
                .map(carName -> new Car(carName, randomValueGenerator))
                .collect(Collectors.toList()));
    }

    public int validateRepetitionNum(int repetitionNum) {
        if (repetitionNum <= EXCLUSIVE_MIN_REPETITION_NUM) {
            throw new IllegalArgumentException("반복 횟수는 0보다 커야 합니다.\n");
        }
        return repetitionNum;
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Cars calculateWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(INITIAL_POSITION);

        ArrayList<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        return new Cars(winners);
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    public String getNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public String getPositions() {
        return cars.stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
                .collect(Collectors.joining("\n"))
                .concat("\n");
    }
}
