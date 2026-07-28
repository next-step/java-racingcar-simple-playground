package domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerFinder {

    public List<String> findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return collectWinners(cars, maxPosition);
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(
                    maxPosition,
                    car.getPosition()
            );
        }

        return maxPosition;
    }

    private List<String> collectWinners(
            List<Car> cars,
            int maxPosition
    ) {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            addWinner(car, maxPosition, winners);
        }

        return winners;
    }

    private void addWinner(
            Car car,
            int maxPosition,
            List<String> winners
    ) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car.getName());
        }
    }
}