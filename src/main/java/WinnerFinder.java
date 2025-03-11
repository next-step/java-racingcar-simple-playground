import java.util.ArrayList;
import java.util.List;

public class WinnerFinder {
  private List<Car> cars;
  private int maxPosition;

  public List<Integer> findWinners(List<Car> cars) {
    this.cars = cars;
    maxPosition = getMaxPosition();
    return getWinners();
  }

  public List<Integer> getWinners() {
    List<Integer> winners = new ArrayList<>();
    for (Car car : cars) {
      checkWinner(winners, car);
    }
    return winners;
  }

  private void checkWinner(List<Integer> winners, Car car) {
    if (car.getPosition() == maxPosition) {
      winners.add(car.getIndex());
    }
  }

  private int getMaxPosition() {
    int max = 0;
    for (Car car : cars) {
      max = Math.max(max, car.getPosition());
    }
    return max;
  }
}
