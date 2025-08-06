import java.util.List;

import util.InputParser;
import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {
        final List<String> carNames = InputParser.parseCarNames(InputView.getCarNames());
        final int tryCount = InputParser.parseNumberOfRounds(InputView.getNumberOfRounds());

        CarSimulator carSimulator = new CarSimulator(carNames, tryCount);
        carSimulator.simulate();
        ResultView.printWinners(carSimulator.getWinners());
    }
}
