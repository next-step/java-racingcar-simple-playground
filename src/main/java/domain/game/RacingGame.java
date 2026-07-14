package domain.game;

import domain.car.Car;
import domain.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final NumberGenerator generator;

    public RacingGame(List<Car> cars, NumberGenerator generator) {
        this.cars = new ArrayList<>(cars);
        this.generator = generator;
    }

    public void run(int count) {
        validateCount(count);

        for (int i = 0; i < count; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(generator.generate());
        }
    }

    public List<Car> findWinners() {
        int max = maxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == max)
                .toList();
    }

    private int maxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Car 목록이 비어있습니다."));
    }

    private void validateCount(int count) {
        if(count <= 0){
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
