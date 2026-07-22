package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import domain.Car;

public class View {
    List<Car> cars = new ArrayList<>();

    private String input;
    private int number;
    private String[] carNames;

    public View(String input) {
        this.input = input;
        Scanner scanner = new Scanner(input);
        this.carNames = scanner.nextLine().split(",");
        this.number = scanner.nextInt();
    }

    public List<Car> enrollCars() throws Exception {
        for (String carName : carNames) {
            if (carName.length() > 5 || carName == null) {
                throw new Exception("이름의 길이는 5자를 넘을 수 없습니다.");
            }
            cars.add(new Car(carName));
        }
        return cars;
    }

    public int getNum() {
        return number;
    }
}
