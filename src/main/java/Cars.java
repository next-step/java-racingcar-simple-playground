import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCars(String value) {
        String[] names = value.split(",");
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
