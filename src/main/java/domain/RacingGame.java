package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int tryCount;
    private final Number number;

    public RacingGame(List<Car> cars, Number number) { // 테스트용 생성자
        this.cars = cars;
        this.tryCount = 1;
        this.number = number;
    }

    public RacingGame(List<String> carNames, int tryCount) {
        this(carNames, tryCount, new RandomNumber());
    }

    public RacingGame(List<String> carNames, int tryCount, Number number) {
        this.cars = toCars(carNames);
        this.tryCount = tryCount;
        this.number = number;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(number.getNumber());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();
        return findCarsAt(maxPosition);
    }

    public int getTryCount() {
        return tryCount;
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<Car> findCarsAt(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .toList();
    }

    private static List<Car> toCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
