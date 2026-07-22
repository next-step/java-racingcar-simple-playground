import controller.RacingGameController;
import domain.rand.Move;
import domain.rand.RandomMove;
import view.InputView;

public class RacingGameApplication {

    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int THRESHOLD = 4;

    public static void run() {
        InputView inputView = new InputView(System.in);
        Move move = new RandomMove(MIN, MAX, THRESHOLD);

        RacingGameController racingGameController = new RacingGameController(inputView, move);
        racingGameController.gameStart();
    }
}
