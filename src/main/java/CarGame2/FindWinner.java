package CarGame2;

import java.util.ArrayList;
import java.util.List;

public class FindWinner {
    private final List<Car> cars;

    public FindWinner(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return findWinners(maxPosition);
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<String> findWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(winners, car, maxPosition);

        }
        return winners;
    }

    private static void addWinner(List<String> winners, Car car, int maxPosition) {
        if (isWinner(car, maxPosition)) {
            winners.add(car.getName());
        }
    }

    private static boolean isWinner(Car car, int maxPosition) {
        return car.getPosition() == maxPosition;
    }
}
