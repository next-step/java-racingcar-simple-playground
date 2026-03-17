package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int START_POSITION = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private void addIfWinner(List<Car> winners, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }

    private int getMaxPosition() {
        int maxPosition = START_POSITION;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        return maxPosition;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addIfWinner(winners, car, maxPosition);
        }
        return winners;
    }
}
