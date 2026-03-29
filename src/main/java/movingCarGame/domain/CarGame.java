package movingCarGame.domain;

import java.util.List;
import movingCarGame.util.DefaultRandomGenerator;
import movingCarGame.util.RandomGenerator;

public class CarGame {
    private final List<Car> cars;
    private final RandomGenerator random;

    public CarGame(List<Car> cars) {
        this.cars = cars;
        this.random = new DefaultRandomGenerator();
    }

    public CarGame(List<Car> cars, RandomGenerator random) {
        this.cars = cars;
        this.random = random;
    }


    public List<Car> getWinners() {
        int max = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == max)
                .toList();
    }

    public void play() {
        cars.forEach(car -> car.move(random.generateRandomValue()));
    }

    public List<Car> getCars() {
        return cars;
    }
}
