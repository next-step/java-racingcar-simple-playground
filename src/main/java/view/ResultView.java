package view;

import domain.RacingCar;

import java.util.List;

public class ResultView {
    public static void result(List<RacingCar> cars) {
        System.out.println("\n실행 결과");

        for (RacingCar car : cars) {
            System.out.println(car.getName()+ ":" + car.getPosition());
        }
    }

    public static void printWinner(List winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
