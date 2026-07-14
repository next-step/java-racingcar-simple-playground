import java.util.List;
import java.util.Random;

public class Race {
    private List<Car> cars;
    private final Random random = new Random();

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    // --------------------------------------------------

    public void raceStart(int rounds) {
        for (int i = 0; i < rounds; i++) {
            playRound();
        }
    }

    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();
        return findCarsAt(maxPosition);
    }

    // --------------------------------------------------

    private void playRound() {
        for (Car car : cars) {
            car.move(random.nextInt(10));
        }
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<Car> findCarsAt(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .toList();
    }
}
