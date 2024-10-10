import java.util.List;

public class CarGame {

  private final List<Car> cars;

  public CarGame(final List<Car> cars) {
    this.cars = cars;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void play(final int round) {
    for (int i = 0; i < round; i++) {
      move();
    }
  }

  private void move() {
    cars.forEach(Car::move);
  }
}

