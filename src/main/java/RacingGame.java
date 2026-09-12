import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void race(int count) {
        for (int i = 0; i < count; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(getRandomValue());
        }
    }

    private int getRandomValue() {
        return new Random().nextInt(RANDOM_BOUND);
    }

    private int findMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = findMaxPosition();

        for (Car car : cars) {
            addWinner(car, maxPosition, winners);
        }

        return winners;
    }

    private void addWinner(Car car, int maxPosition, List<Car> winners) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }
}
