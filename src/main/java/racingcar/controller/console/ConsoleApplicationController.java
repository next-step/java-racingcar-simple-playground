package racingcar.controller.console;

import racingcar.controller.text.TextApplicationController;
import racingcar.view.text.ApplicationTextInput;
import racingcar.view.text.ApplicationTextInputHandler;
import racingcar.view.text.ApplicationView;


public class ConsoleApplicationController extends TextApplicationController {

    private final ConsolePromptHandler promptHandler = new ConsolePromptHandler();
    private final ConsoleTextNodePrinter nodePrinter = new ConsoleTextNodePrinter();

    @Override
    protected ApplicationTextInput promptViewInput() {
        ApplicationTextInputHandler inputHandler = new ApplicationTextInputHandler(promptHandler);
        return inputHandler.promptInput();
    }

    @Override
    protected void printView(ApplicationView node) {
        nodePrinter.print(node);
    }

}
