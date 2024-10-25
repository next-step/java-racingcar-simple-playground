import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRace {
  private final List<RacingCar> cars = new ArrayList<>();
  private final int rounds;
  private final List<Integer> coWinners = new ArrayList<>();

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

  private void updateAllWinners(int number, int winningDistance) {
    if(cars.get(number).getDistance() == winningDistance)
      coWinners.add(number);
  }

  public void displayAllWinners() {
    int winningDistance = findWinningDistance();

    for(int i = 0; i < cars.size(); i++)
      updateAllWinners(i, winningDistance);

    System.out.println("Winner:");
    for(int coWinnerIndex : coWinners)
      System.out.println(cars.get(coWinnerIndex).getName());
  }
}