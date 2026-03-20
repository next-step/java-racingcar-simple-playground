package model;


import java.util.ArrayList;
import java.util.List;

public class CarsWinner {
    private final List<String> winners = new ArrayList<>();


    public List<String> findWinners(Cars cars) {
        int maxPosition = findMaxPosition(cars);
        for (Car car : cars.getCars()) {
            checkAndAddWinner(winners, car, maxPosition);
        }
        return winners;
    }

    private void checkAndAddWinner(List<String> winners, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }

    private int findMaxPosition(Cars cars) {
        int maxPosition = 0;
        for (Car car : cars.getCars()) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        return maxPosition;
    }
}
