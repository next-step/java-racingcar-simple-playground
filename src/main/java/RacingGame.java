import java.util.List;
import java.util.ArrayList;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        validateCars(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateCars(List<Car> cars) {
        if (cars == null) {
            throw new IllegalArgumentException("자동차 리스트는 null일 수 없습니다");
        }
    }

    public void race(int rounds) {
        validateRounds(rounds);
        for (int i = 0; i < rounds; i++) {
            moveAllCars();
        }
    }

    private void validateRounds(int rounds) {
        if (rounds < 0) {
            throw new IllegalArgumentException("경주 횟수는 0 이상이어야 합니다");
        }
    }

    private void moveAllCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> getWinners() {
        if (cars.isEmpty()) {
            return new ArrayList<>();
        }
        int maxPosition = findMaxPosition();
        return findCarsAtPosition(maxPosition);
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private List<String> findCarsAtPosition(int targetPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == targetPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
