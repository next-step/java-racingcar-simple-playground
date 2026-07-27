package domain;

import java.util.ArrayList;
import java.util.List;

public class FindWinner {
    private int longestPosition = 0;
    private List<String> winnerNames = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();

    public FindWinner(List<Car> cars) {
        this.cars = cars;
    }

    public int findLongestPosition() {
        for (Car car : cars) {
            if (car.getPosition() >= longestPosition) {
                longestPosition = car.getPosition();
            }
        }
        return longestPosition;
    }

    public List<String> findWinnerName(int longestPosition) {
        for (Car car : cars) {
            if (car.getPosition() == longestPosition) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
