package domain;

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

  public List<String> getWinners() {
    return coWinners;
  }

  public void carMove(int number) {
    for(RacingCar car : cars)
      car.move(number);
  }

  public void runRace() {
    System.out.println("실행 결과");
    for (int i = 0; i < rounds; i++) {
      moveAllCars();
    }
    int winningDistance = findWinningDistance();
    updateAllWinners(winningDistance);
  }

  private void moveAllCars() {
    Random random = new Random();
    for(RacingCar car : cars) {
      int randNum = random.nextInt(1, 11);
      car.move(randNum);
      System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
    }
    System.out.println(" ");
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
}