package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarListGenerator {

    private final Scanner scanner = new Scanner(System.in);

    public List<Car> generateCars(List<String> carNames) { //외부에서 받는다고 가정

        List<Car> cars = new ArrayList<>(carNames.size());
        for (String name : carNames) {
            cars.add(new Car(name, 0));
        }
        return cars;
    }

}
