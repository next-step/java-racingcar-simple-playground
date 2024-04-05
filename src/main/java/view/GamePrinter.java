package view;

import java.util.List;
import java.util.StringJoiner;

public class GamePrinter {

    private static final String RESULT_START = "실행 결과";
    private static final String DISTANCE_FORMAT = "-";

    public static void printResultStart() {
        System.out.println("\n" + RESULT_START);
    }

    public static void printCarResult(String name, int distance) {
        System.out.println(name + " : " + DISTANCE_FORMAT.repeat(distance));
    }

    public static void printRaceWinners(List<String> winnerNames) {
        StringJoiner joiner = new StringJoiner(", ");
        for (String name : winnerNames) {
            joiner.add(name);
        }
        System.out.printf(joiner.toString() + "가 최종 우승했습니다.");
    }

}
