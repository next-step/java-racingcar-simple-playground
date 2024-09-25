package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<CarName> carNames) {
//        List<Car> cars = new ArrayList<Car>();
//        for (CarName carName : carNames) {
//            cars.add(new Car(carName));
//        }
//        return new Cars(cars);


        return new Cars(
                carNames.stream().map(Car::new).collect(Collectors.toList())
        );

    }

    public List<Car> getCars() {
        return cars;
    }
}
