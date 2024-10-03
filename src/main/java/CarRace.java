import java.util.ArrayList;

public class CarRace {
  public RacingCar[] cars;
  private final int rounds;
  private int winnerIndex;
  private final ArrayList<Integer> coWinners = new ArrayList<>();

  public CarRace(int car_num, int round_num) {
    rounds = round_num;
    cars = new RacingCar[car_num];
    for (int i = 0; i < car_num; i++) {
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

  private void findAllWinners(int number, int winning_distance) {
    if(cars[number].distance == winning_distance)
      coWinners.add(number);
  }

  public void displayAllWinners() {
    int winning_distance = findWinningDistance();

    for(int i = 0; i < cars.length; i++)
      findAllWinners(i, winning_distance);

    System.out.println("Winner:");
    for(int coWinnerIndex : coWinners)
      System.out.println(cars[coWinnerIndex].name);
  }
}