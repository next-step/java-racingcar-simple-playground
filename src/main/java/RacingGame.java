import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

  private final List<Car> cars;
  private final int round;

  /**
   * Constructor `self`
   */
  public RacingGame() {
    this.cars = new ArrayList<>();
    this.round = 0;
  }

  /**
   * Constructor `self`
   *
   * @param names 입력받은 차량 이름들
   * @param round     입력받은 게임 라운드 수
   */
  public RacingGame(List<String> names, int round) {
    this.round = round;
    this.cars = new ArrayList<>();

    for (String name : names) {
      this.addCar(Car.makeCar(name));
    }
  }

  public List<Car> getCars() {
    return this.cars;
  }


  public int getRound() {
    return this.round;
  }

  public int getCurrentCarCount() {
    return this.cars.size();
  }

  /**
   * @param car 게임 참여 차량
   */
  public void addCar(Car car) {
    this.cars.add(car);
  }

  /**
   * 게임 진행
   */
  public void proceedGame() {
    this.cars.forEach(Car::move);
  }

  /**
   * @return winners 현재 우승자 이름 배열
   */
  public List<String> getWinnerNames() {
    int maxLocation = 0;
    List<String> winners = new ArrayList<>();

    for (Car car : this.cars) {
      int carLocation = car.getCoordinateX();
      if (maxLocation < carLocation) {
        maxLocation = carLocation;
        winners.clear();
        winners.add(car.getName());
      } else if (maxLocation == carLocation) {
        winners.add(car.getName());
      }
    }

    return winners;
  }
}
