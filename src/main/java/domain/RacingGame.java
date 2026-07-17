package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int tryCount;
    private final NumberGenerator numberGenerator;
    private final MovingStrategy movingStrategy;

    public RacingGame(List<Car> cars, NumberGenerator numberGenerator) { // 테스트용 생성자
        this.cars = cars;
        this.tryCount = 1;
        this.numberGenerator = numberGenerator;
        this.movingStrategy = new NumberMovingStrategy();
    }

    public RacingGame(List<String> carNames, int tryCount) { // 기본 레이싱 게임
        this(carNames, tryCount, new RandomNumberGenerator(), new NumberMovingStrategy());
    }

    public RacingGame(List<String> carNames, int tryCount, NumberGenerator numberGenerator) {
        this(carNames, tryCount, numberGenerator, new NumberMovingStrategy());
    }

    public RacingGame(List<String> carNames, int tryCount, MovingStrategy movingStrategy) {
        this(carNames, tryCount, new RandomNumberGenerator(), movingStrategy);
    }

    public RacingGame(List<String> carNames, int tryCount, NumberGenerator numberGenerator, MovingStrategy movingStrategy) {
        this.cars = toCars(carNames);
        this.tryCount = tryCount;
        this.numberGenerator = numberGenerator;
        this.movingStrategy = movingStrategy;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(movingStrategy, numberGenerator.generate());
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
