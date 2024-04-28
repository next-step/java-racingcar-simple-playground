package racingcar.domain;

import java.util.Collections;
import java.util.List;

public record Cars(List<Car> cars) {

    public static Cars createCarsWithGenerator(final List<String> carNames, final NumberGenerator numberGenerator) {
        return new Cars(carNames.stream()
                .map(name -> new Car(name, numberGenerator))
                .toList());
    }

    public Cars moveForward() {
        return new Cars(cars.stream()
                .map(Car::moveForward)
                .toList());
    }

    public Cars findWinners() {
        int winnerPosition = findWinnerPosition();

        return new Cars(cars.stream()
                .filter(car -> car.isSamePosition(winnerPosition))
                .toList());
    }

    private int findWinnerPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("우승자를 찾을 수 없습니다."));
    }

    @Override
    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }
}
