package view;

import domain.Car;

import java.util.List;

public class RacingGamePlayView {

    private static final String MOVE_INDICATOR = "-";

    public void informWillPrintRaceResult() {
        System.out.println("실행 결과");
    }

    public void printCarStatuses(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(formatCarStatus(car));
        }
        printEmptyLine();
    }

    private String formatCarStatus(Car car) {
        return car.getName() + " : " + MOVE_INDICATOR.repeat(car.getMoveDistance());
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
