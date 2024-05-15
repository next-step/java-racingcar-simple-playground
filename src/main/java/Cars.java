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

    public List<Car> getMaxMoveCars(int maxPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .toList();
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
