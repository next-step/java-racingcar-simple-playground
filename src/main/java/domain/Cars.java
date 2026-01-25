package domain;

import java.util.List;

public final class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public void moveAll(RandomNumberGenerator generator) {
        for (Car car : cars) {
            car.move(generator);
        }
    }

    public int maxPosition() {
        return cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElse(0);
    }


    public List<Car> findByPosition(int position) {
        return cars.stream()
                .filter(car -> car.position() == position)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
