import java.util.List;

import domain.MoveNumberGenerator;
import domain.RacingGame;
import infrastructure.RandomMoveNumberGenerator;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.runGame();
    }

    private void runGame() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MoveNumberGenerator moveNumberGenerator = new RandomMoveNumberGenerator();

        List<String> carNames = inputView.getCarNames();

        RacingGame racingGame = new RacingGame(carNames, moveNumberGenerator);

        int round = inputView.getRound();

        outputView.printStartMessage();

        for (int i = 0; i < round; i++) {
            racingGame.playRound();
            outputView.printRoundResult(racingGame.getCarSnapshots());
        }

        outputView.printWinners(racingGame.findWinners());
    }
}
