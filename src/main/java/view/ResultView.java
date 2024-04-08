package view;

import java.util.List;

public class ResultView {
    //우승자 출력
    public static void printWinners(List<String> winners) {
        if (winners.isEmpty()) {
            System.out.println("우승자가 없습니다.");
        } else {
            for (int i = 0; i < winners.size(); i++) {
                System.out.print(winners.get(i));
                if (i != winners.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("가 최종 우승했습니다.");
        }
    }
}
