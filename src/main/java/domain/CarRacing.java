package domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

  private final Cars cars;
  private static final int MIN_ATTEMPTS = 1;

  public CarRacing(List<String> carNames, int attempts, NumberGenerator numberGenerator) {
    validateAttempts(attempts);
    this.cars = new Cars(carNames, numberGenerator);
  }

  public void playRound() {
    cars.moveAllCars();
  }

  public List<String> findWinners() {
    List<Car> carList = cars.getCars();
    int maxPosition = carList.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(0);
    return carList.stream()
        .filter(car -> car.getPosition() == maxPosition)
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  public List<Car> getCars() {
    return cars.getCars();
  }

  public static void validateAttempts(int attempts) {
    if (attempts < MIN_ATTEMPTS) {
      throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
    }
  }
}
