package car.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();

    public RacingCars(List<String> carNames){
        carNames.forEach(carName -> cars.add(new Car(carName)));
    }

    public List<Car> getCars() {
        return cars;
    }


}
