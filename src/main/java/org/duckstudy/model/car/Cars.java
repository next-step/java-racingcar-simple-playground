package org.duckstudy.model.car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.duckstudy.model.generator.RandomValueGenerator;

public class Cars {

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
        int maxPosition = calculateMaxPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .toList();
        return new Cars(winners);
    }

    private int calculateMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalStateException::new);
    }

    public List<String> getAllNames() {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }

    public List<Integer> getAllPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }
}
