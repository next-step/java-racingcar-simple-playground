package racingcar.view;

import java.util.List;
import racingcar.domain.MoveResults;

public class OutputView {

    public void printMoveResults(final List<MoveResults> moveResults) {
        System.out.println("실행 결과");
        moveResults.forEach(this::printSingleMoveResult);
        System.out.println();
    }

    private void printSingleMoveResult(MoveResults moveResults) {
        moveResults.results()
                .stream()
                .map(m -> m.carName() + " : " + "-".repeat(m.currentPosition()))
                .forEach(System.out::println);
        System.out.println();
    }

    public void printWinners(final List<String> winners) {
        String winnerMessage = String.join(", ", winners);
        System.out.println(winnerMessage + "가 최종 우승했습니다.");
    }
}
