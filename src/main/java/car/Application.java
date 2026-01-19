package car;

import car.domain.RacingGame;
import car.domain.RandomMovingStrategy;
import car.view.InputView;
import car.view.OutputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<String> names = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        RacingGame game = new RacingGame(names);

        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            game.playOneRound(new RandomMovingStrategy()); // 전략 주입
            OutputView.printRoundResult(game.getCars());  // 뷰에 데이터 전달
        }

        OutputView.printWinners(game.getWinners());
    }
}