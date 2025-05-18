package racinggame.view;

import racinggame.model.car.Car;

import java.util.List;

public class OutputView {
    public static void printResult(List<Car> cars) {
        System.out.println("\n실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getMovedDistance()));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

}
