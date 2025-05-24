package util;

import domain.Car;
import domain.GeneratedRandInt;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InOutputView {
    public static void printCarsMoving(List<Car> cars) {
        for (Car car : cars) {
            String bar = "-".repeat(car.getLocation());
            System.out.println(car.getName() + ": " + bar);
        }

        System.out.print("\n");
    }

    public static List<Car> inputCar(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return generateCar(input);
    }

    private static List<Car> generateCar(String input) {
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, new GeneratedRandInt()));
        }
        return cars;
    }

    public static int inputTime(Scanner scanner) {
        System.out.println("경기횟수를 입력하세요");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자가 아닙니다");
            throw e;
        }
    }
}
