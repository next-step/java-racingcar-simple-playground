import java.util.ArrayList;
import java.util.List;

public class RacingGame {

  private final List<Car> cars;

  public List<Car> getCars() {
    return this.cars;
  }

  public RacingGame() {
    this.cars = new ArrayList<>();
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
      }else if (maxLocation == carLocation) {
        winners.add(car.getName());
      }
    }

    return winners;
  }
}
