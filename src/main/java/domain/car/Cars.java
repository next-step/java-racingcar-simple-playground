package domain.car;

import domain.racegame.MoveStrategy;
import domain.racegame.RandomNumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        if (cars.size() <= 1) {
            throw new IllegalArgumentException("자동차 수는 최소 2대여야 합니다.");
        }
        this.cars = cars;
    }

    public void raceOneRound(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            car.move(moveStrategy, randomNumber);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getCarPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("자동차가 없습니다."));
    }

    public List<String> findWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getCarPosition() == maxPosition)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
