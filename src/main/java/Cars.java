import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void moveAll() {
        for (Car car : cars) {
            int number = (int) (Math.random() * 10);
            car.move(number);
        }
    }

    public List<Car> getWinners() {
        int max = getMaxPosition();
        return cars.stream().filter(car -> car.getPosition() == max).toList();
    }

    private int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }
}
