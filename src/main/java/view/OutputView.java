package view;

import java.util.List;

public class OutputView {
    private static final String WINNER_DELIMITER = ", ";

    public void printInputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printInputGameRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printGameResult(String gameResult) {
        System.out.print("\n실행결과");
        System.out.println(gameResult);
    }

    public void printWinnerCarNames(List<String> carNames) {
        System.out.print(String.join(WINNER_DELIMITER, carNames));
        System.out.println("가 최종 우승했습니다.");
    }
}
