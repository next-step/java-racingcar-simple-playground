package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int tryCount;
    private final NumberGenerator numberGenerator;

    public RacingGame(List<Car> cars, NumberGenerator numberGenerator) { // 테스트용 생성자
        this.cars = cars;
        this.tryCount = 1;
        this.numberGenerator = numberGenerator;
    }

    public RacingGame(List<String> carNames, int tryCount) {
        this(carNames, tryCount, new RandomNumberGenerator());
    }

    public RacingGame(List<String> carNames, int tryCount, NumberGenerator numberGenerator) {
        this.cars = toCars(carNames);
        this.tryCount = tryCount;
        this.numberGenerator = numberGenerator;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
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
