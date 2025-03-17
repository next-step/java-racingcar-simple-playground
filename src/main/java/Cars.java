import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private static final int MIN_CAR_COUNT = 2;
  private static final int MIN_ATTEMPTS = 1;

  private final List<Car> cars;

  public Cars(List<String> carNames) {
    List<Car> carList = new ArrayList<>();
    for (String carName : carNames) {
      carList.add(new Car(carName));
    }
    this.cars = List.copyOf(new ArrayList<>(carList));
  }

  public void moveAllCars() {
    for (Car car : cars) {
      car.move();
    }
  }

  public List<String> findWinners() {
    int maxPosition = cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(0);
    return cars.stream()
        .filter(car -> car.getPosition() == maxPosition)
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  public static void validateCarCount(int carCount) {
    if (carCount < MIN_CAR_COUNT) {
      throw new IllegalArgumentException("자동차 대수는 2 이상이어야 합니다.");
    }
  }

  public static void validateAttempts(int attempts) {
    if (attempts < MIN_ATTEMPTS) {
      throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
    }
  }

  public List<Car> getCars() {
    return List.copyOf(new ArrayList<>(cars));
  }
}
