import java.util.*;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void playRound() {
        List<Integer> numbers = makeNumbers();
        moveCars(numbers);
    }

    public void moveCars(List<Integer> numbers) {
        for(int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int number = numbers.get(i);

            car.move(number);
        }
    }

    public List<Integer> makeNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < cars.size(); i++) {
            numbers.add(random.nextInt(10));
        }

        return numbers;
    }

    public int findMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;

        for(Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winners = new ArrayList<>();

        for(Car car : cars) {
            addIfWinner(car, maxPosition, winners);
        }

        return winners;
    }

    private void addIfWinner(Car car, int maxPosition, List<Car> winners) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }
}
