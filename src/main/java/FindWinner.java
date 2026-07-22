import java.util.ArrayList;
import java.util.List;

public class FindWinner {
    private Car[] cars;
    private int longestPosition = 0;
    private List<String> winnerNames = new ArrayList<>();

    public FindWinner(Car[] cars) {
        this.cars = cars;
    }

    public void startRacing() {
        for (int i = 0; i <= 7; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    public int FindLongestPosition() {
        for (Car car : cars) {
            if (car.getPosition() >= longestPosition) {
                longestPosition = car.getPosition();
            }
        }
        return longestPosition;
    }

    public List<String> FindWinnerName() {
        for (Car car : cars) {
            if (car.getPosition() == longestPosition) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
