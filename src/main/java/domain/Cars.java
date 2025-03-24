package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  private final List<Car> cars;
  private static final int MIN_CAR_COUNT = 2;

  public Cars(List<String> carNames, NumberGenerator numberGenerator) {
    validateCarCount(carNames.size());
    this.cars = createCarList(carNames, numberGenerator);
  }

  private static List<Car> createCarList(List<String> carNames, NumberGenerator numberGenerator) {
    List<Car> carList = new ArrayList<>();
    for (String carName : carNames) {
      carList.add(new Car(carName, numberGenerator));
    }
    return List.copyOf(carList);
  }

  public void moveAllCars() {
    for (Car car : cars) {
      car.move();
    }
  }

  public List<Car> getCars() {
    return List.copyOf(cars);
  }

  public static void validateCarCount(int carCount) {
    if (carCount < MIN_CAR_COUNT) {
      throw new IllegalArgumentException("경주에는 최소 2대의 자동차가 필요합니다.");
    }
  }
}
