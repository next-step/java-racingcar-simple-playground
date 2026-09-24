package domain;

import generator.NumberGenerator;
import java.util.ArrayList;

public class CarRace {
    private Cars cars;
    private NumberGenerator numberGenerator;

    public CarRace(Cars cars, NumberGenerator numberGenerator) {
        validateCars(cars);
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    private void validateCars(Cars cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 입력 안 됨");
        }
    }

    public void moveCars() {
        for (Car car : cars.getCars()) {
            car.moveCar(numberGenerator);
        }
    }

    public ArrayList<Car> getWinners() {
        int maxPosition = findMaxPosition();
        ArrayList<Car> winners = new ArrayList<>();
        for (Car car : cars.getCars()) {
            addWinners(car, maxPosition, winners);
        }
        return winners;
    }

    private int findMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars.getCars()) {
            maxPosition = car.getLargerPosition(maxPosition);
        }

        return maxPosition;
    }

    private void addWinners(Car car, int maxPosition, ArrayList<Car> winners) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car);
        }
    }
}
