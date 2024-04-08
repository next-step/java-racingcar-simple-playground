package view;

import domain.Car;
import domain.Cars;
import java.util.List;

public class OutputView {

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printCarsInfo(final Cars cars) {
        for (final Car car : cars.getCars()) {
            final String name = car.getName();
            final String position = getPositionFormat(car.getPosition());
            System.out.printf("%s : %s\n", name, position);
        }
        System.out.println();
    }

    private static String getPositionFormat(final int position) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public static void printResultOfWinningCars(final Cars winningCars) {
        final List<Car> cars = winningCars.getCars();
        final List<String> carNames = cars.stream()
                .map(Car::getName)
                .toList();
        final String winningCarNames = String.join(", ", carNames);
        System.out.printf("%s가 최종 우승했습니다.\n", winningCarNames);
    }
}
