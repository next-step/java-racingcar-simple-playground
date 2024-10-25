import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRace {
  private final List<RacingCar> cars = new ArrayList<>();
  private final int rounds;
  private final List<String> coWinners = new ArrayList<>();

  public CarRace(final int rounds, String carNames) {
    this.rounds = rounds;
    Arrays.stream(carNames.split(","))
        .map(RacingCar::new)
        .forEach(cars::add);
  }

  public void runRace() {
    for(int i = 0; i < rounds; i++)
      moveAllCars();
  }

  private void moveAllCars() {
    for(RacingCar car : cars)
      car.move();
  }

  private int findWinningDistance() {
    return cars.stream()
        .mapToInt(RacingCar::getDistance)
        .max()
        .orElse(0);
  }

  private void updateAllWinners(int winningDistance) {
    cars.stream()
        .filter(c -> c.getDistance() == winningDistance)
        .forEach(c -> coWinners.add(c.getName()));
  }

  public void displayAllWinners() {
    int winningDistance = findWinningDistance();
    updateAllWinners(winningDistance);

    System.out.println("Winner:");
    coWinners.forEach(System.out::println);
  }
}