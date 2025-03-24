package view;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printInputRoundNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printProcess(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(formatCarInfo(car));
        }
        System.out.println();
    }

    public static String formatCarInfo(Car car) {
        return car.getName() + " : " + "-".repeat(car.getDistance());
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public static String formatWinnerNames(List<String> cars) {
        return cars.toString().replace("[", "").replace("]", "");
    }

}
