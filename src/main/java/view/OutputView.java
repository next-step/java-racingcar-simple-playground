package view;

import java.util.List;

public class OutputView {
    public static void printResultMessage() {
        printNewLine();
        System.out.println("실행 결과");
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String result = String.join(",", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
