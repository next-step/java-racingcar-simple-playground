package view;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printWinners(List<Car> winners) {
        final String winnerNames = winners
            .stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
