import java.util.List;

public class CarRunner {

  public static void runRace(List<Car> cars, int attempts) {
    for (int round = 1; round <= attempts; round++) {
      moveAllCars(cars);
      RaceOutput.printRound(cars, round);
    }
    RaceOutput.printResult(cars);
  }

  private static void moveAllCars(List<Car> cars) {
    for (Car car : cars) {
      car.move();
    }
  }
}
