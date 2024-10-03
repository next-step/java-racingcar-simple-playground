public class CarRace {
  public RacingCar[] cars;
  private final int rounds;

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
}