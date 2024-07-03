package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import domain.Car;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static List<Car> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> cars = Arrays.stream(sc.nextLine().split(",")).toList();
        for (String carName : cars) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다. 잘못된 이름: " + carName);
            }
        }
        List<Car> carList = cars.stream().map(Car::new).toList();
        return carList;
    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return sc.nextInt();
    }
}
