package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public CarRace(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void race(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            playRound();
        }

    }

    private void playRound() {
        for (Car car : cars) {
            int number = numberGenerator.generate();
            car.move(number);
        }
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxPosition == car.getPosition()) {
                winners.add(car);
            }
        }
        return winners;
    }
}