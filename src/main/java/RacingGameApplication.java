import controller.RacingGameController;
import domain.RandomMoveStrategy;
import view.InputView;

import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {
        List<String> names = InputView.inputNames();
        int tries = InputView.inputTries();

        RacingGameController controller = new RacingGameController(names, tries, new RandomMoveStrategy());
        controller.start();
    }
}