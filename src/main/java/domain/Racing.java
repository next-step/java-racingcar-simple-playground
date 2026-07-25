package domain;

import java.util.ArrayList;
import java.util.List;

import view.View;

public class Racing {
    private List<Car> cars = new ArrayList<>();
    View view = new View();

    public List<Car> enrollCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void eachCarRacing() {
        for (Car car : cars) {
            int randomNumber = (int) (Math.random() * 10);
            car.move(randomNumber);
            view.printCarPosition(car);
        }
        System.out.println("\n");
    }

    public void startRacing(int count) {
        view.printRacingResult();
        for (int i = 0; i < count; i++) {
            eachCarRacing();
        }
    }
}
