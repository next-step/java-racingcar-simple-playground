package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarsFactory {
    public static List<Car> createCars(String namesInput) {
        String[] names = namesInput.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;

    }
}
