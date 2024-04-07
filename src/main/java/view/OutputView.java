package view;

import java.util.List;

public class OutputView {

    public static void printRaceStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRaceScore(List<String> carNames, List<Integer> carScores) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + "-".repeat(carScores.get(i)));
        }
        System.out.println();
    }

    public static void printRaceWinner() {

    }
}
