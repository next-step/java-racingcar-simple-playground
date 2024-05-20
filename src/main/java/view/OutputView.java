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

    public void printResult(final List<Car> cars) {
        System.out.printf("{0}가 최종 우승했습니다.", getWinnerNames(cars));
    }

    private String getWinnerNames(final List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cars.size() -1; i++) {
            Car car = cars.get(i);
            stringBuilder.append(car.getName()).append(", ");
        }
        Car last = cars.get(cars.size() - 1);
        stringBuilder.append(last);

        return stringBuilder.toString();
    }
}
