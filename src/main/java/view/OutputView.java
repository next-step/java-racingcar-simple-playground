package view;

import model.Car;

import java.util.List;

public class OutputView {

    private static final String PROGRESS_FORMAT = "-";
    private static final String WINNER_DELIMITER = ", ";

    public static void printRacing(final List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("\n%s : %s", car.getName(),getProgressVar(car.getPosition()));
        }
        System.out.println();
    }

    private static String getProgressVar(int position) {
        return PROGRESS_FORMAT.repeat(position);
    }

    public static void printResult(final List<Car> cars) {
        System.out.printf("\n%s가 최종 우승했습니다.", getWinnerNames(cars));
    }

    private static String getWinnerNames(final List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cars.size() -1; i++) {
            Car car = cars.get(i);
            stringBuilder.append(car.getName()).append(WINNER_DELIMITER);
        }
        Car last = cars.get(cars.size() - 1);
        stringBuilder.append(last.getName());
        return stringBuilder.toString();
    }
}
