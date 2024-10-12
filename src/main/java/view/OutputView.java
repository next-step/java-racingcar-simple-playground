package view;

import java.util.List;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printRound(List<String> round) {
        for(String line : round) {
            System.out.println(line);
        }
        printNewLine();
    }
}
