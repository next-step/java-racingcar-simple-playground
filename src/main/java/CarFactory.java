import java.util.ArrayList;
import java.util.List;

public class CarFactory {

  private final List<Car> cars;

  public CarFactory() {
    this.cars = new ArrayList<>();
  }

  public void addCar(String name) {
    cars.add(new Car(name));
  }

  public List<Car> getCars() {
    return cars;
  }
}
