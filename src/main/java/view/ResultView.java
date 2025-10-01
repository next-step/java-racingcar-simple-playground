package view;
import java.util.List;

public class ResultView {
    public static void printRoundResult(List<String> carResults) {
        for (String result : carResults) {
            System.out.println(result);
        }
        System.out.println();
    }

    public static void printWinner(String winnerNames) {
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
