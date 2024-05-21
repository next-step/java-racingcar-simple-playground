package model;

import java.util.*;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String[] carNames) {
        validateDuplicatedName(carNames);
        final List<Car> cars = Arrays.stream(carNames)
                .map(name -> new Car(name, new RandomMoveStrategy()))
                .toList();

        return new Cars(cars);
    }

    private static void validateDuplicatedName(final String[] carNames) {
        final Set<String> notDuplicatedNames = new HashSet<>(Arrays.asList(carNames));
        if (notDuplicatedNames.size() != carNames.length) {
            throw new IllegalArgumentException("중복된 이름을 가진 차들이 존재합니다.");
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getMaxMoveCars(int maxPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .toList();
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
