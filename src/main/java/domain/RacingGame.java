package domain;

import java.util.List;
import java.util.ArrayList;

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

    public List<CarSnapshot> getCarSnapshots() {
        List<CarSnapshot> snapshots = new ArrayList<>();

        for (Car car : cars) {
            CarSnapshot snapshot = CarSnapshot.from(car);
            snapshots.add(snapshot);
        }

        return List.copyOf(snapshots);
    }

    public void playRound() {
        for(Car car : cars) {
            int number = numberGenerator.generate();
            car.move(number);
        }
    }

    public List<CarSnapshot> findWinners() {
        int maxPosition = findMaxPosition();

        List<CarSnapshot> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(CarSnapshot::from)
                .toList();

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
