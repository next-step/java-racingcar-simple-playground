package view;

import domain.Car;

import java.util.List;

public class outputView {

    private static final String CAR_POSITION_EXPRESSION = "-";
    private static final String WINNER_NAMES_DELIMITER = ",";

    public static void printGameResultTitle() {
        System.out.print("\n실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + ": " + CAR_POSITION_EXPRESSION.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printGameWinners(List<String> winners) {
        System.out.println(String.join(WINNER_NAMES_DELIMITER, winners) + "가 최종 우승했습니다.");
    }
}
