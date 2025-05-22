import java.util.List;
import utils.NumberGenerator;

public class RacingGameController {

    private final RacingGameView view;
    private final NumberGenerator numberGenerator;

    public RacingGameController(RacingGameView view, NumberGenerator numberGenerator) {
        this.view = view;
        this.numberGenerator = numberGenerator;
    }

    public void start() {
        List<Car> cars = view.inputCars();
        int round = view.inputRound();

        RacingGame racingGame = new RacingGame(numberGenerator, cars);

        for (int i = 0; i < round; i++) {
            racingGame.moveForward();
            view.printRoundResult(racingGame.getCars());
        }

        view.printWinners(racingGame.getWinners());
    }
}
