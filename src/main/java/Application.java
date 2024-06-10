import controller.RacingGameController;
import view.InputView;

public class Application {

    public static void main(String[] args) {
        final String[] carNames = InputView.readCarNames();
        final int racingCount = InputView.readRacingCount();

        final RacingGameController controller = RacingGameController.of(carNames, racingCount);
        controller.race();
    }
}
