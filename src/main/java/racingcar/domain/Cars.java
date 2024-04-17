package racingcar.domain;

import java.util.Collections;
import java.util.List;

public record Cars(List<Car> cars) {

    public static Cars createDefault(final List<String> carNames, final NumberGenerator numberGenerator) {
        return new Cars(carNames.stream()
                .map(name -> Car.createDefault(name, numberGenerator))
                .toList());
    }

    public Cars moveForward() {
        return new Cars(cars.stream()
                .map(Car::moveForward)
                .toList());
    }

    public Cars findWinners() {
        int winnerPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("우승자를 찾을 수 없습니다."));

        return new Cars(cars.stream()
                .filter(car -> car.isSamePosition(winnerPosition))
                .toList());
    }

    @Override
    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }
}
