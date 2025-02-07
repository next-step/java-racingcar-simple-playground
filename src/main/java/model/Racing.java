package model;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Racing {

    private final Random random;

    private final int gameCount;
    private final int carCount;
    private final List<Car> cars;

    public Racing(Random random, int gameCount, int carCount) {
        this.random = random;
        this.gameCount = gameCount;
        this.carCount = carCount;
        this.cars = initCars(carCount);
    }

    public List<Car> play() {
        runGame();

        return getWinners(getMaxDistance());
    }

    private List<Car> initCars(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> new Car("test" + i, random))
                .toList();
    }

    private void runGame() {
        Stream.iterate(0, i -> i + 1)
                .limit(gameCount)
                .forEach(i ->
                        cars.forEach(Car::move)
                );
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<Car> getWinners(int maxDistance) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxDistance)
                .toList();
    }
}
