import java.util.ArrayList;

public class CarRace {
  public RacingCar[] cars;
  private final int rounds;
  private int winnerIndex;
  private final ArrayList<Integer> coWinners = new ArrayList<>();

  public CarRace(int carNum, int roundNum) {
    rounds = roundNum;
    cars = new RacingCar[carNum];
    for (int i = 0; i < carNum; i++) {
      cars[i] = new RacingCar("자동차" + (i+1));
    }
  }

  public void setCarName(int number, String name) {
    cars[number].name = name;
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
    for(int i = 0; i < cars.length; i++)
      updateWinner(i);
    return cars[winnerIndex].distance;
  }

  private void updateWinner(int number) {
    if (number < cars.length - 1 && cars[number].distance < cars[number + 1].distance)
      winnerIndex = number + 1;
  }

  private void findAllWinners(int number, int winningDistance) {
    if(cars[number].distance == winningDistance)
      coWinners.add(number);
  }

  public void displayAllWinners() {
    int winningDistance = findWinningDistance();

    for(int i = 0; i < cars.length; i++)
      findAllWinners(i, winningDistance);

    System.out.println("Winner:");
    for(int coWinnerIndex : coWinners)
      System.out.println(cars[coWinnerIndex].name);
  }
}