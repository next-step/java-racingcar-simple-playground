package view;

import model.Car;

import java.util.List;

public class OutputView {

    public static final String PROGRESS_FORMAT = "-";

    public void printRacing(final List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("{0} : {1}", car.getName(),getProgressVar(car.getPosition()));
        }
    }

    private String getProgressVar(int position) {
        return PROGRESS_FORMAT.repeat(position);
    }
}
