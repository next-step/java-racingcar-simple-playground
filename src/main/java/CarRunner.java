import java.util.List;

public class CarRunner {

  public static void runRace(Cars cars, int attempts) {
    for (int round = 1; round <= attempts; round++) {
      cars.moveAllCars();
      RaceOutput.printRound(cars, round);
    }
    List<String> winners = cars.findWinners();
    RaceOutput.printResult(cars, winners);
  }
}
