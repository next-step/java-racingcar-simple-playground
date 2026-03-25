import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private final List<Car> cars;

    public RaceResult(List<Car> newCars) {
        this.cars = new ArrayList<>(newCars);
    }

    public List<Car> getResult() {
        List<Car> resultCars = new ArrayList<>();
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition).max()
                .orElse(0);
        resultCars = cars.stream().filter(car -> car.getPosition() == maxPosition)
                .toList();
        return resultCars;
    }
}
