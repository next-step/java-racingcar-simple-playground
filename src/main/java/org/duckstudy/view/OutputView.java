package org.duckstudy.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    public void printInputCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printInputRepetitionNumMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printIntermediateResult(List<String> carNames, List<Integer> positions) {
        String message = IntStream.range(0, carNames.size())
                .mapToObj(i -> carNames.get(i) + " : " + "-".repeat(positions.get(i)))
                .collect(Collectors.joining("\n"));
        System.out.println(message.concat("\n"));
    }

    public void printWinnerNames(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames).concat("가 최종 우승했습니다."));
    }

    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
