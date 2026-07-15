package view;

import domain.RacingCar;
import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public static void printRound(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public static void printWinners(List<RacingCar> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (RacingCar winner : winners) {
            winnerNames.add(winner.getName());
        }
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}