import controller.RacingGameController;
import domain.NumberGenerator;
import domain.RandomNumberGenerator;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        RacingGameController controller = new RacingGameController(inputView, outputView, numberGenerator);
        controller.run();
    }
}
