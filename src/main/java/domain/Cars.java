package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(String[] carNames, NumberGenerator numberGenerator) {
        List<Car> newCars = new ArrayList<Car>();
        for (String carName : carNames) {
            newCars.add(new Car(carName, numberGenerator));
        }
        return new Cars(newCars);
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    public Cars findCarsInPosition(int position) {
        List<Car> carsInPosition = new ArrayList<>();
        return new Cars(
                cars.stream()
                        .filter(car -> car.isInPosition(position))
                        .collect(Collectors.toList())
        );
    }

    public List<Car> getCars() {
        return cars;
    }
}
