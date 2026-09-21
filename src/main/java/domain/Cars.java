package domain;

import domain.movement.NumberGenerater;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private NumberGenerater numberGenerater;

    public Cars(List<String> names, NumberGenerater numberGenerater) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("자동차가 0대일 수 없습니다.");
        }

        this.cars = new ArrayList<>();
        this.numberGenerater = numberGenerater;

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            moveIfPossible(car);
        }
    }

    private void moveIfPossible(Car car) {
        int number = numberGenerater.generate();
        if(Car.isMovable(number)) {
            car.move();
        }
    }

    public int findMaximum() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> filterByPosition(int target) {
        return cars.stream()
                .filter(car ->car.isSamePosition(target))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
