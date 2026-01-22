package car;

import car.domain.CarGroup;
import car.domain.RacingGame;
import car.domain.RandomMovingStrategy;
import car.view.InputView;
import car.view.OutputView;

public class Application {

    public static void main(String[] args) {

        CarGroup carGroup = InputView.getCars();
        int tryCount = InputView.getTryCount();

        RacingGame game = new RacingGame(carGroup);

        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            game.playOneRound(new RandomMovingStrategy()); // 전략 주입
            OutputView.printRoundResult(game.getCars());  // 뷰에 데이터 전달
        }

        OutputView.printWinners(game.getWinners());
    }
}
