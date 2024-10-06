import java.util.ArrayList;
import java.util.List;

public class RacingGame {

  private List<Car> cars;

  public RacingGame() {
    this.cars = new ArrayList<>();
  }

  public void addCar(Car car) {
    this.cars.add(car);
  }

  public int getCurrentCarCount() {
    return this.cars.size();
  }
}
