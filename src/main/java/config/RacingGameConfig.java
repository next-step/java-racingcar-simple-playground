package config;

import controller.RacingGameController;
import domain.NumberGenerator;
import domain.RandomNumberGenerator;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

public class RacingGameConfig {

    public RacingGameController racingGameController() {
        return new RacingGameController(inputView(), outputView(), numberGenerator());
    }

    private InputView inputView() {
        return new ConsoleInputView();
    }

    private OutputView outputView() {
        return new ConsoleOutputView();
    }

    private NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }
}
