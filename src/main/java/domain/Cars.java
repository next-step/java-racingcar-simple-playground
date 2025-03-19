package domain;

import static controller.CarRunner.validateCarCount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private final List<Car> cars;

  public Cars(List<String> carNames,NumberGenerator numberGenerator) {
    validateCarCount(carNames.size());
    List<Car> carList = new ArrayList<>();
    for (String carName : carNames) {
      carList.add(new Car(carName,numberGenerator));
    }
    this.cars = List.copyOf(carList);
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

  public List<Car> getCars() {
    return List.copyOf(cars);
  }
}
