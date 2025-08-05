import controller.GameController;
import model.RacingGame;
import view.InputView;
import view.OutputView;

import java.util.Random;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGame game = new RacingGame(new Random());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        GameController controller = new GameController(game, inputView, outputView);
        controller.startGame();
    }
}
