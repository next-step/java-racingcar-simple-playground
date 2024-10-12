import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

  private final List<Car> cars;

  public RacingGame() {
    this.cars = new ArrayList<>();
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
  public List<String> getWinners() {
    int maxLocation = 0;
    List<String> winners = new ArrayList<>();

    for (Car car : this.cars) {
      getCarWinner(car, maxLocation, winners);
    }

    return winners;
  }

  /**
   * @param car 비교할 자동차
   * @param maxLocation 현재 최고 거리
   * @param winners 우승자 이름 배열
   */
  private static void getCarWinner(final Car car, final int maxLocation,
      final List<String> winners) {
    if (maxLocation < car.getCoordinateX()) {
      winners.clear();
      winners.add(car.getName());
    }

    if (maxLocation == car.getCoordinateX()) {
      winners.add(car.getName());
    }
  }

  public int getCurrentCarCount() {
    return this.cars.size();
  }
}
