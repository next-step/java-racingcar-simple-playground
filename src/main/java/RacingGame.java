import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int max = -1;
        for (Car car : cars) {
            if (max < car.getLocation()) {
                max = car.getLocation();
            }
        }
        for (Car car : cars) {
            if (car.getLocation() == max) {
                winners.add(car);
            }
        }
        return winners;
    }
}
