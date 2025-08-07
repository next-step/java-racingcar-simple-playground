import view.InputView;
import view.ResultView;
import domain.RacingGame;

public class Application {
    public static void main(String[] args) {
        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getTryCount();
        final var racingGame = new RacingGame(carNames, tryCount);

        playRacingGame(racingGame, tryCount);
    }

    private static void playRacingGame(RacingGame racingGame, int tryCount) {
        ResultView.printRaceStart();

        for (int i = 0; i < tryCount; i++) {
            racingGame.playOneRound();
            ResultView.printRaceResult(racingGame.getCars());
        }

        ResultView.printWinners(racingGame.getWinners());
    }
}
