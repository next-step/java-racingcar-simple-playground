import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class Application {

    public static void main(String[] args) {
        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getTryCount();

        final var racingGame = new RacingGame(carNames, tryCount);
        final var raceResults = racingGame.race();

        ResultView.printRaceResults(raceResults);
        ResultView.printWinners(racingGame.getWinners());
    }
}