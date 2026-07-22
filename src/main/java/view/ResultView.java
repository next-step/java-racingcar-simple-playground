package view;

import domain.RacingCar;

import java.util.List;

public class ResultView {

    public static void printGameStart() {
        System.out.println("실행 결과");
    }

    public static void printTurnResult(List<RacingCar> cars) {
        for(RacingCar car : cars) {
            System.out.println(car.getName() + " : " + car.getDistanceToString());
        }
        System.out.println();
    }

    public static void printFinalResult(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}
