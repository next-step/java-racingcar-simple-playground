package view;

import domain.Car;

import java.util.List;

public class ResultView {

    public static void printWinners(List<Car> winnerCars) {
        System.out.println("실행 결과");
        String winnerNames = String.join(", ",
                winnerCars.stream().map(Car::getName).toArray(String[]::new)
        );
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
