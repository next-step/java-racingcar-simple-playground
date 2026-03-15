import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            addWinner(winners, car, maxPosition);
        }
        return winners;
    }

    private void addWinner(List<Car> winners, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}