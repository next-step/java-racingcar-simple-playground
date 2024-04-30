package view;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String MARKER = "-";

    public static void printStatus(final List<Car> cars) {
        System.out.println(cars.stream()
                .map(car -> String.format("%s : %s", car.getName(), getPositionString(car.getPos())))
                .collect(Collectors.joining(System.lineSeparator())));
        System.out.println();
    }

    public static void printWinners(final List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    private static String getPositionString(final int pos) {
        return MARKER.repeat(pos);
    }
}