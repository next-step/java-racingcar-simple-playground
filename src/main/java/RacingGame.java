import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

  private final List<Car> cars;

  public RacingGame() {
    this.cars = new ArrayList<>();
  }

  public void addCar(Car car) {
    this.cars.add(car);
  }

  public void proceedGame() {
    Random random = new Random();
    this.cars.forEach((car) -> {
      int randomNumber = random.nextInt(9);
      car.move(randomNumber);
    });
  }

  public List<String> getWinners() {
    int maxLocation = 0;
    List<String> winners = new ArrayList<>();

    for (Car car : this.cars) {
      if (maxLocation < car.getCoordinateX()) {
        winners.clear();
        winners.add(car.getName());
      }

      if (maxLocation == car.getCoordinateX()) {
        winners.add(car.getName());
      }
    }
    return winners;
  }

  public int getCurrentCarCount() {
    return this.cars.size();
  }
}
