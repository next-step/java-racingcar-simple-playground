package CarGame2.domain.model;

import CarGame2.domain.service.NumberGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void moveAll(NumberGenerator generator) {
        for (Car car : cars) {
            int speed = generator.generate();
            car.move(speed);
        }
    }

    public List<String> findWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> isWinner(car, maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private boolean isWinner(Car car, int maxPosition) {
        return car.getPosition() == maxPosition;
    }

    private int getMaxPosition() {
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
