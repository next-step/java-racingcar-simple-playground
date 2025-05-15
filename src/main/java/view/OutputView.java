package view;

import data.CarSnapShot;
import data.RoundResult;

import java.util.List;

public class OutputView {

    public static void printWinners(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    public static void printRoundResult(RoundResult roundResult) {
        List<CarSnapShot> carSnapShots = roundResult.getCarSnapShots();
        carSnapShots.stream()
                .forEach(carSnapShot -> System.out.println(carSnapShot.getCarName() + " : " + "-".repeat(carSnapShot.getDistance())));
        System.out.println();
    }

}
