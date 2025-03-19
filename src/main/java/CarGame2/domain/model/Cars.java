package CarGame2.domain.model;

import CarGame2.domain.service.Generator;
import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> carsList = new ArrayList<>();
        for (String name : carNames) {
            carsList.add(new Car(name));
        }
        return carsList;
    }

    public void moveAll(Generator generator) {
        for (Car car : cars) {
            int speed = generator.generate();
            car.move(speed);
        }
    }

    public List<String> findWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(winners, car, maxPosition);
        }
        return winners;
    }

    private void addWinner(List<String> winners, Car car, int maxPosition) {
        if (isWinner(car, maxPosition)) {
            winners.add(car.getName());
        }
    }

    private boolean isWinner(Car car, int maxPosition) {
        return car.getPosition() == maxPosition;
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}

