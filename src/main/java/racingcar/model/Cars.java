package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int START_POSITION = 0;
    private final List<Car> cars;

    public Cars(List<String> names) {
        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
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

}
