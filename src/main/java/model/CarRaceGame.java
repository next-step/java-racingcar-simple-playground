package model;

import java.util.ArrayList;
import java.util.List;

public class CarRaceGame {
    final List<Car> cars;

    public CarRaceGame(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> playSingleRoundAndGetCars() {
        for (Car car: cars) {
            car.moveByProbability();
        }

        return cars;
    }

    public List<String> getWinners() {
        final List<String> winners = new ArrayList<>();
        int maxDistance = 0;

        for (Car car: cars) {
            int carDistance = car.getDistance();
            String carName = car.getName();

            if (carDistance > maxDistance) {
                winners.clear();
                maxDistance = carDistance;
            }

            if (carDistance >= maxDistance) {
                winners.add(carName);
            }
        }

        return winners;
    }
}
