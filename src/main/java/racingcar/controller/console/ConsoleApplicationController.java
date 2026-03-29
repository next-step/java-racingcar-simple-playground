package racingcar.controller.console;

import racingcar.domain.CarRacing;
import racingcar.view.text.ApplicationView;
import racingcar.view.text.ApplicationViewInput;
import racingcar.view.text.ApplicationViewInputHandler;


public class ConsoleApplicationController extends TextApplicationController {

    private final ConsolePromptHandler promptHandler = new ConsolePromptHandler();
    private final ConsoleTextNodePrinter nodePrinter = new ConsoleTextNodePrinter();

    @Override
    protected ApplicationViewInput promptViewInput() {
        ApplicationViewInputHandler inputHandler = new ApplicationViewInputHandler(promptHandler);
        return inputHandler.promptInput();
    }

    @Override
    protected void printView(ApplicationView node) {
        nodePrinter.print(node);
    }

}
