package view;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import model.Car;

public class GameView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Car> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.stream(scanner.nextLine().split(","))
            .map(String::trim)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public static int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public static void printRaceResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
