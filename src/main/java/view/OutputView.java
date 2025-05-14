package view;

import java.util.List;
import model.RaceRecorder;
import model.RaceRound;
import model.dto.CarRecord;

public class OutputView {
    private static final String RESULT_OF_EXECUTION_HEADER = "실행 결과";

    private OutputView() {
    }

    public static void printResultHeader() {
        System.out.println();
        System.out.println(RESULT_OF_EXECUTION_HEADER);
    }

    public static void printAllRaceRounds(RaceRecorder raceRecorder) {
        for (RaceRound round : raceRecorder.getRaceRounds()) {
            printRoundRecord(round);
        }
    }

    private static void printRoundRecord(RaceRound round) {
        for (CarRecord carRecord : round.carRecords()) {
            System.out.println(carRecord.name() + " : " + "-".repeat(carRecord.position()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
