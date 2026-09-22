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

    public void race(int roundCount) { // 이제 사용안함
        for (int i = 0; i < roundCount; i++) {
            playRound();
        }

    }

    public void playRound() {
        for (Car car : cars) {
            int number = numberGenerator.generate();
            car.move(number);
        }
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

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }//인스턴스


}
