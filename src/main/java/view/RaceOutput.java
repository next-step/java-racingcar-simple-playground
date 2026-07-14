package view;

import domain.Car;

import java.util.List;

public class RaceOutput {

    private static final String RESULT_SEPARATOR = " : ";
    private static final String RESULT_MESSAGE = "실행 결과";

    public void showResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void showResult(List<Car> cars) {
        for (Car car : cars) {
            showLocation(car);
        }
    }

    private void showLocation(Car car) {
        System.out.println(car.getName() + RESULT_SEPARATOR + car.getLocation());
    }
}
