import java.util.ArrayList;
import java.util.List;

public class CarRace {
  public List<RacingCar> cars = new ArrayList<>();
  private final int rounds;
  private int winnerIndex;
  private final List<Integer> coWinners = new ArrayList<>();

  public CarRace(int carNum, final int rounds) {
    this.rounds = rounds;
    for (int i = 0; i < carNum; i++) {
      cars.add(new RacingCar("자동차" + (i+1)));
    }
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
    winnerIndex = 0;
    for(int i = 0; i < cars.size(); i++)
      updateWinner(i);
    return cars.get(winnerIndex).getDistance();
  }

  private void updateWinner(int number) {
    if (number < cars.size() - 1 && cars.get(number).getDistance() < cars.get(number+1).getDistance())
      winnerIndex = number + 1;
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