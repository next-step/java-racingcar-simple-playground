package view;

import java.util.List;

public class ResultView {

    public static void printRaceResult() {
        System.out.println("실행 결과");
    }

    public static void printRaceStatus(List<String> carStatuses) {
        for (String status : carStatuses) {
            System.out.println(status);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
