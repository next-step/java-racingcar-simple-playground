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
    this.cars.forEach((car) -> {
      car.move();
    });
  }

  public List<String> getWinners() {
    int maxLocation = 0;
    List<String> winners = new ArrayList<>();

    for (Car car : this.cars) {
      getCarWinner(car, maxLocation, winners);
    }

    return winners;
  }

  private static void getCarWinner(final Car car, final int maxLocation,
      final List<String> winners) {
    if (maxLocation < car.getCoordinateX()) {
      winners.clear();
      winners.add(car.getName());
    }

    if (maxLocation == car.getCoordinateX()) {
      winners.add(car.getName());
    }
  }

  public int getCurrentCarCount() {
    return this.cars.size();
  }
}
