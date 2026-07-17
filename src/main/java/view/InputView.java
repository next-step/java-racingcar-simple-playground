package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Car;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static List<Car> readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = SCANNER.nextLine().split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName.strip()));
        }
        validateEmptyCars(cars);
        return cars;
    }

    private static void validateEmptyCars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차는 최소 1대 이상 필요합니다.");
        }
    }

    public static int tryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return SCANNER.nextInt();
    }
}
