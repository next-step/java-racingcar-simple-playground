package racingcar.domain;

import java.util.Collections;
import java.util.List;

public record Cars(List<Car> cars) {

    public Cars moveForward(final NumberGenerator generator) {
        return new Cars(cars.stream()
                .map(car -> car.moveForward(generator.generateNumber()))
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
