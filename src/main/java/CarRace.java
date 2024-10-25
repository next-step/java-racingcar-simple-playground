import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CarRace {
  private final int rounds;
  private final List<RacingCar> cars = new ArrayList<>();
  private final List<String> coWinners = new ArrayList<>();

  public CarRace(final int rounds, String carNames) {
    this.rounds = rounds;
    Arrays.stream(carNames.split(","))
        .map(RacingCar::new)
        .forEach(cars::add);
  }

  public int getDistance(int index) {
    return cars.get(index).getDistance();
  }

  public List<String> getWinnersName() {
    return updateAllWinners(findWinningDistance());
  }

  public List<String> getCoWinners() {
    return coWinners;
  }

  public void carMove(int number) {
    for(RacingCar car : cars)
      car.move(number);
  }

  public void runRace() {
    for (int i = 0; i < rounds; i++) {
      moveAllCars();
    }
  }

  private void moveAllCars() {
    Random random = new Random();
    for(RacingCar car : cars) {
      int randNum = random.nextInt(1, 11);
      car.move(randNum);
    }
  }

  private int findWinningDistance() {
    return cars.stream()
        .mapToInt(RacingCar::getDistance)
        .max()
        .orElse(0);
  }

  private List<String> updateAllWinners(int winningDistance) {
    cars.stream()
        .filter(c -> c.getDistance() == winningDistance)
        .forEach(c -> coWinners.add(c.getName()));
    return coWinners;
  }

  public void displayAllWinners() {
    int winningDistance = findWinningDistance();
    updateAllWinners(winningDistance);

    System.out.println("Winner:");
    coWinners.forEach(System.out::println);
  }
}