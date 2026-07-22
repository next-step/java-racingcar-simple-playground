package mission4;

import mission2.Racing;
import mission4.view.InputView;
import mission4.view.ResultView;

public class MissionMain {
    public static void main(String[] args) {

        final var carNameArr = InputView.getCarNames();
        final var racingCount = InputView.getTryCount();

        Racing racing = new Racing(carNameArr, racingCount, new RandomNum(10));

        racing.start();
        ResultView.printRoundResult(racing.getHistory());
        ResultView.printWinner(racing.getWinners());
    }
}
