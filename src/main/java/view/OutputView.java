package view;

import java.util.List;

public class OutputView {

    public static void printWinnerCarNames(List<String> winnnerCarNames) {
        String winnerCarsPrintFormat = "";
        for (String currentCarName : winnnerCarNames) {
            winnerCarsPrintFormat += currentCarName + ", ";
        }
        System.out.println(winnerCarsPrintFormat.substring(0, winnerCarsPrintFormat.length() - 2) + "가 최종 우승했습니다.");
    }
}