package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int START_POSITION = 0;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addIfWinner(winners, car, maxPosition);
        }
        return winners;
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

    void moveCarAt(int index, NumberGenerator numberGenerator) {
        if (isValidateIndex(index)) {
            cars.get(index).moveForward(numberGenerator);
        }
    }

    private boolean isValidateIndex(int index) {
        return index >= 0 && index < cars.size();
    }
}
