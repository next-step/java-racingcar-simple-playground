import domain.Race;
import domain.RandomArrayGenerator;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final String[] carNames = inputView.inputCarNames();
        Race race = new Race(carNames);
        final int moveCount = inputView.inputMoveCount();

        RandomArrayGenerator generator = new RandomArrayGenerator();
        race.raceCars(moveCount, generator.generateRandom2DArray(carNames.length, moveCount));
        final List<List<Integer>> moveHistories = race.getMoveHistories();
        final List<String> winners = race.getWinners(moveHistories);

        final OutputView outputView = new OutputView();
        outputView.printRaceResult(moveHistories, carNames, winners);
    }
}
