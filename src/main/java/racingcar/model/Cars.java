package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int START_POSITION = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.moveForward(numberGenerator));
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addIfWinner(winners, car, maxPosition);
        }
        return winners;
    }

    public List<CarStatus> getCarsStatus() {
        return cars.stream()
                .map(car -> new CarStatus(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    private void addIfWinner(List<String> winners, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
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
