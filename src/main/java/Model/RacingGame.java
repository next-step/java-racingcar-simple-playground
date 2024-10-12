package Model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

  private int maxPos = 0;

  private final List<Car> carList = new ArrayList<>();


  public void createCarList(List<String> nameList) {
    for (String name : nameList) {
      carList.add(new Car(name));
    }
  }

  private void getMaxPos() {
    int maxPos = 0;
    for (Car car : carList) {
      maxPos = Math.max( maxPos, car.getPos() );
    }

    this.maxPos = maxPos;
  }

  private boolean isWinner(Car car) {
    if (maxPos == car.getPos()) {
      return true;
    }
    else {
      return false;
    }
  }

  public void run() {
    for (Car car : carList) {
      car.move();
    }
  }

  public List<String> getWinnerList() {
    List<String> winnerList = new ArrayList<>();

    getMaxPos();

    winnerList = carList.stream()
        .filter( car -> isWinner(car) )
        .map(Car::getName)
        .toList();

    return winnerList;

  }

  public List<Car> getCarList() {
    return carList;
  }

}
