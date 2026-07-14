package view;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RaceOutput {

    private static final String POSITION_MARK = "-";
    private static final String RESULT_SEPARATOR = " : ";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String DEFAULT_SEPARATOR = ", ";

    public void showResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void showResult(List<Car> cars) {
        System.out.println(formatCars(cars));
    }

    public void showWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE + String.join(DEFAULT_SEPARATOR, winners));
    }

    private String formatCars(List<Car> cars) {
        return cars.stream()
                .map(this::formatCar)
                .collect(Collectors.joining(DEFAULT_SEPARATOR));
    }

    private String formatCar(Car car) {
        return car.getName() + RESULT_SEPARATOR + POSITION_MARK.repeat(car.getLocation());
    }
}
