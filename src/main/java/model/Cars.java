package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private List<Car> cars = new ArrayList<>();

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public Cars(final String[] carNames) {
    for (final String carName : carNames) {
      cars.add(new Car(carName));
    }
  }


  public void move() {
    for (final Car car : cars) {
      car.move();
    }
  }

  public int getMaxScore() {
    return cars.stream()
        .mapToInt(Car::getScore)
        .max()
        .orElse(0);
  }

  public List<String> getCarNames() {
    return cars.stream()
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  public List<Integer> getCarScores() {
    return cars.stream()
        .map(Car::getScore)
        .collect(Collectors.toList());
  }

  public List<String> getWinners() {
    return cars.stream()
        .filter(car -> car.getScore() == getMaxScore())
        .map(Car::getName)
        .collect(Collectors.toList());
  }
}
