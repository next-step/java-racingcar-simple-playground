package racingcar.controller.text;

import racingcar.domain.CarRacing;
import racingcar.view.text.ApplicationTextInput;
import racingcar.view.text.ApplicationView;


public abstract class TextApplicationController {

    protected abstract ApplicationTextInput promptViewInput();

    protected abstract void printView(ApplicationView view);

    public void playCarRacing() {
        ApplicationTextInput input = promptViewInput();
        ApplicationView view = playGame(input);
        printView(view);
    }

    private ApplicationView playGame(ApplicationTextInput input) {
        CarRacing racing = new CarRacing(input.carNames(), input.gameCount());
        CarRacing.GameResult result = racing.playGame();

        return new ApplicationView(result);
    }

}
