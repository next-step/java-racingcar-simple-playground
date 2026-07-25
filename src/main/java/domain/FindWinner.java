package domain;

import view.View;
import java.util.ArrayList;
import java.util.List;

public class FindWinner {
    View view = new View();
    private int longestPosition = 0;
    private List<String> winnerNames = new ArrayList<>();

    public int FindLongestPosition(List<Car> cars) {
        for (Car car : cars) {
            if (car.getPosition() >= longestPosition) {
                longestPosition = car.getPosition();
            }
        }
        return longestPosition;
    }

    public List<String> FindWinnerName(List<Car> cars) {
        for (Car car : cars) {
            if (car.getPosition() == longestPosition) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
