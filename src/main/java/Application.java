import java.util.List;

import domain.NumberGenerator;
import domain.RacingGame;
import util.RandomNumberGenerator;
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
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        List<String> carNames = inputView.getCarNames();

        RacingGame racingGame = new RacingGame(carNames, numberGenerator);

        int round = inputView.getRound();

        outputView.printStartMessage();

        for (int i = 0; i < round; i++) {
            racingGame.playRound();
            outputView.printRoundResult(racingGame.getCars());
        }

        outputView.printWinners(racingGame.findWinners());
    }
}
