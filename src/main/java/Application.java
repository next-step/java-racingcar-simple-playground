import domain.RacingGame;
import domain.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RacingGame racingGame = new RacingGame(InputView.readCars(), randomNumberGenerator);
        int tryCount = InputView.tryCount();

        ResultView.printRaceResult();
        runRace(racingGame, tryCount);
        ResultView.printWinners(racingGame.findWinners());
    }

    private static void runRace(RacingGame racingGame, int tryCount) {
        for (int count = 0; count < tryCount; count++) {
            racingGame.moveCars();
            ResultView.printCars(racingGame.getCars());
        }
    }
}
