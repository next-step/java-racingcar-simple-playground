import domain.NumberGenerator;
import domain.RacingGame;
import domain.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        final var carNames = inputView.getCarNames();
        final var tryCount = inputView.getTryCount();

        NumberGenerator numberGenerator =
                new RandomNumberGenerator();

        RacingGame racingGame = new RacingGame(
                carNames,
                tryCount,
                numberGenerator
        );

        final var raceResults = racingGame.race();
        final var winners = racingGame.getWinners();

        resultView.printRaceResults(raceResults);
        resultView.printWinners(winners);
    }
}