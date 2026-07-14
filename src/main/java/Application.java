import controller.GameController;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(), new ResultView());
        gameController.run();
    }
}
