import domain.generator.NumberGenerator;
import domain.generator.RandomNumberGenerator;
import domain.game.RacingGame;
import view.CarNameInput;
import view.RaceOutput;
import view.RaceTrialNumberInput;

public class Application {

    public static void main(String[] args) {
        new Application().run();
    }

    private void run() {
        RacingGame racingGame = createRacingGame();
        int trialNumber = getTrialNumber();

        RaceOutput raceOutput = new RaceOutput();
        race(racingGame, trialNumber, raceOutput);
        raceOutput.showWinners(racingGame.findWinners());
    }

    private RacingGame createRacingGame() {
        return new RacingGame(new CarNameInput().getCarName());
    }

    private int getTrialNumber() {
        return new RaceTrialNumberInput().getRaceTrialNumber();
    }

    private void race(RacingGame racingGame, int trialNumber, RaceOutput raceOutput) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        raceOutput.showResultMessage();
        for (int count = 0; count < trialNumber; count++) {
            racingGame.race(numberGenerator);
            raceOutput.showResult(racingGame.getCars());
        }
    }
}
