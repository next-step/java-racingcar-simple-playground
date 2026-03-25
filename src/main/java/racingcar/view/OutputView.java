package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winnerNames) {
        String names = String.join(", ", winnerNames);
        System.out.println(names + "가 최종 우승했습니다.");
    }
}
