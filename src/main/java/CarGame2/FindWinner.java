package CarGame2;

import java.util.ArrayList;
import java.util.List;

public class FindWinner {
    private final Cars cars;

    public FindWinner(Cars cars) {
        this.cars = cars;
    }

    public List<String> getWinners() {
        int maxPosition = cars.getMaxPosition();
        return findWinners(maxPosition);
    }

    private List<String> findWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars.getCars()) {
            addWinner(winners, car, maxPosition);
        }
        return winners;
    }

    private void addWinner(List<String> winners, Car car, int maxPosition) {
        if (isWinner(car, maxPosition)) {
            winners.add(car.getName());
        }
    }

    private boolean isWinner(Car car, int maxPosition) {
        return car.getPosition() == maxPosition;
    }
}
