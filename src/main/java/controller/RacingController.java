package controller;

import domain.Race;
import java.util.List;
import numberGenerator.NumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingController {

    NumberGenerator numberGenerator;

    public RacingController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        final List<String> carNames = InputView.getCarNames();
        final int count = InputView.getTryCount();

        final Race race = new Race(carNames);

        racingGame(count, race);

        OutputView.printWinners(race.getWinners());
    }

    private void racingGame(int count, Race race) {
        OutputView.printResultMessage();

        for (int i = 0; i < count; i++) {
            race.start(numberGenerator);
            race.getResult();
            OutputView.printNewLine();
        }
    }

}
