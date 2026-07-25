package domain;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final NumberGenerator numberGenerator;

    public RacingGame(List<String> carNames, NumberGenerator numberGenerator) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            this.cars.add(car);
        }
        this.numberGenerator = numberGenerator;
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    public void playRound() {
        for(Car car : cars) {
            int number = numberGenerator.generate();
            car.move(number);
        }
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();

        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());

        return winners;
    }

    private int findMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;

        for(Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }
}
