package racingcar.ui;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String MOVING_STATUS = "-";
    public static final String DELIMITER = " : ";
    public static final String WINNER_JOIN_DELIMITER = ", ";

    private OutputView() {

    }

    public static void printGameStart() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarStatus(car);
        }
        System.out.println();
    }

    private static void printCarStatus(Car car) {
        final String builder = car.getName() + DELIMITER + MOVING_STATUS.repeat(car.getPosition());
        System.out.println(builder);
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_JOIN_DELIMITER));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
