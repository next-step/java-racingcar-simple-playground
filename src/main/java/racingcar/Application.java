package racingcar;

import racingcar.controller.GameManageController;
import racingcar.controller.InputValidator;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final InputValidator inputValidator = new InputValidator();

        GameManageController gameManageController = new GameManageController(inputView, outputView, inputValidator);
        gameManageController.readyRacingGame();
        gameManageController.runRacingGame(randomNumberGenerator);
    }
}
