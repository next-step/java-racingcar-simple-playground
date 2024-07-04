package racingcar.domain;

import java.util.List;

import racingcar.RandomNumberGenerator;

public record CarGroup(List<Car> cars) {

    public void move(RandomNumberGenerator generator) {
        for (Car car : cars) {
            car.move(generator);
        }
    }

    public List<Car> getWinners() {
        int max = cars.stream().mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        return cars.stream()
            .filter(car -> car.getPosition() == max)
            .toList();
    }
}
