import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Racing {

    private int times = 0;
    private List<Car> cars = new ArrayList<>();

    public Racing(int times, Car... cars) {
        canOpen(times, cars);
        this.times = times;
        this.cars = List.of(cars);
    }
    public Racing(int times, List<Car> cars) {
        canOpen(times, cars);
        this.times = times;
        this.cars = cars;
    }

    private void canOpen(int times, Car[] car) {
        if (times <= 0) {
            throw new IllegalArgumentException("times must be greater than 0");
        }

        if (car.length == 0) {
            throw new IllegalArgumentException("Racing cars must have at least one car");
        }
    }

    private void canOpen(int times, List<Car> cars) {
        if (times <= 0) {
            throw new IllegalArgumentException("times must be greater than 0");
        }

        if (cars.isEmpty()) {
            throw new IllegalArgumentException("Racing cars must have at least one car");
        }
    }

    public void start() {
        while (times > 0) {
            moveCars();
            showCarsStatus();
            times--;
        }
    }

    private void showCarsStatus() {
        for (Car car : cars) {
            car.showStatus();
        }
        System.out.println();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getWinners() {
        final Integer maxValue = findMaxScore();

        return cars.stream()
            .filter(car -> car.hasWinnerPosition(maxValue))
            .toList();
    }

    private Integer findMaxScore() {
        final Optional<Integer> optional = cars.stream()
            .max(Comparator.comparingInt(Car::getPosition))
            .map(Car::getPosition);
        return optional.get();
    }
}
