package model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf));
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    // 우승자 찾기
    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("경주에 참가한 자동차가 없습니다."));
    }
}
