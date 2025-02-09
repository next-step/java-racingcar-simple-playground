package view;

import java.util.List;

import domain.Car;
import domain.CarGroup;

public class OutputView {

    public static void outputCarsMovement(CarGroup carGroup) {
        for (Car car : carGroup.getCars()) {
            System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void outputStart() {
        System.out.printf("%n[실행 결과]%n");
    }

    public static void outputWinner(List<Car> winners) {
        List<String> winnerNames = winners.stream()
            .map(Car::getName)
            .toList();
        System.out.printf("%s가 최종 우승했습니다.", String.join(", ", winnerNames));
    }
}
