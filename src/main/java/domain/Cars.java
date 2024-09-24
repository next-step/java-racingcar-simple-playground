package domain;

import java.util.List;

// n대의 자동차 참여 가능
// 0~9의 랜덤값 -> 4 이상일 경우 전진기
public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }


    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> findCarsByPosition(final int position) {
        return cars.stream()
                .filter(car -> car.isPositionSame(position))
                .toList();
    }

    public int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }
}
