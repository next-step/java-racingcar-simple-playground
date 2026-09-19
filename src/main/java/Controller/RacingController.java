package Controller;

import domain.Race;
import numberGenerator.NumberGenerator;
import numberGenerator.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingController {

    public void run() {
        final String carNames = InputView.getCarNames();
        final int count = InputView.getTryCount();

        final Race race = new Race(carNames, numberGenerator());

        racingGame(count, race);

        OutputView.printWinners(race.getWinners());
    }

    private NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }

    private void racingGame(int count, Race race) {
        OutputView.printResultMessage();

        for (int i = 0; i < count; i++) {
            race.start();
            race.getResult();
            OutputView.printNewLine();
        }
    }

}
