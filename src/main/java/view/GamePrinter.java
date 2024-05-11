package view;

import java.util.List;
import java.util.StringJoiner;

public class GamePrinter {

    private static final String RESULT_START = "실행 결과";
    private static final String DISTANCE_FORMAT = "-";

    public static void printResultStart() {
        System.out.println("\n" + RESULT_START);
    }

    public static void printCarResult(final String name, final int distance) {
        System.out.println(name + " : " + DISTANCE_FORMAT.repeat(distance));
    }

    public static void printRaceWinners(final List<String> winnerNames) {
        StringJoiner joiner = new StringJoiner(", ");
        for (String name : winnerNames) {
            joiner.add(name);
        }
        System.out.printf(joiner + "가 최종 우승했습니다.");
    }

}
