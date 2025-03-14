import java.util.List;
import java.util.stream.Collectors;

public class WinnerFinder {

  public List<String> findWinners(List<Car> cars) {
    int maxPosition = getMaxPosition(cars);
    return getWinners(cars, maxPosition);
  }

  private List<String> getWinners(List<Car> cars, int maxPosition) {
    return cars.stream()
        .filter(car -> car.getPosition() == maxPosition)
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  private int getMaxPosition(List<Car> cars) {
    return cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(0);
  }
}
