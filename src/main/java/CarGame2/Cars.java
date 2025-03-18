package CarGame2;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;
    private final Generator generator;

    public Cars(List<String> carNames, Generator randomGenerator) {
        this.cars = createCars(carNames);
        this.generator = randomGenerator;
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> carsList = new ArrayList<>();
        for (String name : carNames) {
            carsList.add(new Car(name, generator));
        }
        return carsList;
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
