package io.suhan.racingcar.view;

import io.suhan.racingcar.domain.Car;
import io.suhan.racingcar.domain.RoundResult;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printExecutionResult(List<RoundResult> results) {
        System.out.println("\n실행 결과");
        results.forEach((result) -> printRoundResult(result.getCars()));
    }

    private static void printRoundResult(List<Car> cars) {
        cars.forEach(ResultView::printCurrentPosition);
        System.out.println(); // newline
    }

    public static void printWinners(List<Car> winners) {
        System.out.println(winners.stream().map(Car::getName).collect(Collectors.joining(", ")) + "가 최종 우승했습니다.");
    }

    private static void printCurrentPosition(Car car) {
        System.out.println(car.getName() + " : " + buildProgressBar(car.getPosition()));
    }

    private static String buildProgressBar(int value) {
        return "-".repeat(Math.max(0, value));
    }
}
