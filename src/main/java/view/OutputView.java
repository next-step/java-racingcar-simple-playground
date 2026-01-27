package view;

import domain.RoundResult;

import java.util.List;

public final class OutputView {

    public void printStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRounds(List<RoundResult> rounds) {
        for (RoundResult round : rounds) {
            printCarLine(round);
        }
    }

    public void printCarLine(RoundResult round) {
        for (RoundResult.CarState s : round.states()) {
            System.out.println(s.name() + " : " + "-".repeat(s.position()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
