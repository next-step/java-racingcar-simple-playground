import controller.RacingGameController;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args) {

        RacingGameController racingGameController = new RacingGameController(new InputView(), new ResultView());

        racingGameController.racingStart();

    }
}