import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElseThrow();

        return cars.stream().filter(car -> car.isWinner(maxPosition)).toList();
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
