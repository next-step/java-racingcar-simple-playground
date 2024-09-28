package domain.car;

import domain.racegame.MoveStrategy;
import domain.racegame.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void raceOneRound(MoveStrategy moveStrategy, RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.generateRandomNumber();
            car.move(moveStrategy, randomNumber);
        }
    }

    public List<Car> getCars() {
        return cars;
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
