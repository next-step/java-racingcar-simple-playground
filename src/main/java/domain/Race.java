package domain;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars = new ArrayList<>();

    public void addCars(String[] carNames) {
        for (String name : carNames) {
            if (name.isBlank() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다: " + name);
            }

            cars.add(new Car(name));
        }
    }

    public void removeCars() {
        cars.clear();
    }

    public void moveCars(int rounds) {
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = 0;

        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }

        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }

        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }
}
