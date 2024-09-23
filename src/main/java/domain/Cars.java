package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<CarName> carNames) {
        List<Car> cars = new ArrayList<Car>();
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }

        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
