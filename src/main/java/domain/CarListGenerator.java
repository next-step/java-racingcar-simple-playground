package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarListGenerator {

    private final Scanner scanner = new Scanner(System.in);

    public List<Car> generateCars(int carCount) {

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            System.out.print((i + 1) + "번 자동차의 이름: ");
            String carName = scanner.nextLine();

            Car car = new Car(carName, 0);
            cars.add(car);
        }
        return cars;
    }

}
