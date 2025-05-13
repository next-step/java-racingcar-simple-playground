import controller.RacingGameController;
import domain.generator.NumberGenerator;
import domain.generator.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        RacingGameController gameController = new RacingGameController(inputView, resultView, numberGenerator);
        gameController.run();
    }
}
