package domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars = new ArrayList<>();

    public List<Car> enrollCars(String[] carNames) {
        for (String carName : carNames) {
            try {
                cars.add(new Car(carName));
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
        return cars;
    }

    public List<Car> eachCarRacing(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = (int) (Math.random() * 10);
            car.move(randomNumber);
        }
        return cars;
    }

    public List<Car> startRacing(int count, List<Car> cars) {
        for (int i = 0; i < count; i++) {
            cars = eachCarRacing(cars);
        }
        return cars;
    }
}
