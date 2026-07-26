package domain;

import java.util.ArrayList;
import java.util.List;

public class FindWinner {
    private int longestPosition = 0;
    private List<String> winnerNames = new ArrayList<>();

    public int findLongestPosition(List<Car> cars) {
        for (Car car : cars) {
            if (car.getPosition() >= longestPosition) {
                longestPosition = car.getPosition();
            }
        }
        return longestPosition;
    }

    public List<String> findWinnerName(List<Car> cars, int longestPosition) {
        for (Car car : cars) {
            if (car.getPosition() == longestPosition) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
