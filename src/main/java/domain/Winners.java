package domain;

import domain.car.Car;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    public static List<String> findWinnersNames(List<Car> cars) {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);//값이 비어있을 때는 우승 위치로 0을 사용

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getCarName)
            .collect(Collectors.toList());
    }
}
