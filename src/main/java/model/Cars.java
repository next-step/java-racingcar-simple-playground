package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateMinimumSize(carNames);
        validateDuplicate(carNames);
        this.cars = createCars(carNames);
    }

    private void validateMinimumSize(List<String> carNames) {
        if (carNames == null || carNames.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 자동차 경주는 최소 2대 이상부터 가능합니다.");
        }
    }
    // 자동차 이름 중복 검사
    private void validateDuplicate(List<String> carNames) {
        long uniqueCount = carNames.stream()
                .distinct()
                .count();

        if (uniqueCount != carNames.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> initCars = new ArrayList<>();
        for (String name : carNames) {
            initCars.add(new Car(name.trim()));
        }
        return initCars;
    }

    public void moveAll(NumberGenerator generator) {
        for (Car car : cars) {
            car.move(generator.generate());
        }
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addIfWinner(winners, car, maxPosition);
        }
        return winners;
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    private void addIfWinner(List<Car> winners, Car car, int maxPosition) {
        if (car.isAtPosition(maxPosition)) {
            winners.add(car);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars); // 외부에서 조작하지 못하도록 방어
    }
}
