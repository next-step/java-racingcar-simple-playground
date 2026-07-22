import java.util.*;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void moveCars(List<Integer> numbers) {
        for(int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int number = numbers.get(i);

            car.move(number);
        }
    }

    public int findMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;

        for(Car car : cars) {
            Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winners = new ArrayList<>();

        for(Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }
}
