package racingcar.controller.console;

import racingcar.domain.CarRacing;
import racingcar.view.text.ApplicationView;
import racingcar.view.text.ApplicationViewInput;
import racingcar.view.text.ApplicationViewInputHandler;
import racingcar.view.text.PromptHandler;
import racingcar.view.text.TextView;


public class ApplicationController {

    private final PromptHandler promptHandler = new ConsolePromptHandler();
    private final ConsoleTextNodePrinter nodePrinter = new ConsoleTextNodePrinter();


    public void playCarRacing() {
        ApplicationViewInput input = promptViewInput();
        ApplicationView view = playGame(input);
        printView(view);
    }

    private ApplicationViewInput promptViewInput() {
        ApplicationViewInputHandler inputHandler = new ApplicationViewInputHandler(promptHandler);
        return inputHandler.promptInput();
    }

    private ApplicationView playGame(ApplicationViewInput input) {
        CarRacing racing = new CarRacing(input.carNames(), input.gameCount());
        CarRacing.GameResult result = racing.playGame();

        return new ApplicationView(result);
    }

    private void printView(TextView node) {
        nodePrinter.print(node);
    }

}
