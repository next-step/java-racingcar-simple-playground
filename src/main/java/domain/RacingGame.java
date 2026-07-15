package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    void moveCars(int count) {
        for (int i = 0; i < count; i++) {
            moveCars();
        }
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int winnerLocation = findWinnerLocation();
        for (Car car : cars) {
            addIfWinner(winners, car, winnerLocation);
        }
        return winners;
    }

    private int findWinnerLocation() {
        int max = -1;
        for (Car car : cars) {
            max = Math.max(max, car.getLocation());
        }
        return max;
    }

    private void addIfWinner(List<Car> winners, Car car, int winnerLocation) {
        if (car.getLocation() == winnerLocation) {
            winners.add(car);
        }
    }
}
