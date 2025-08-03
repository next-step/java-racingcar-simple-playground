import java.util.List;

import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args) {
        final List<String> carNames = InputView.getCarNames();
        final int tryCount = InputView.getNumberOfRounds();

        CarSimulator carSimulator = new CarSimulator(carNames, tryCount);
        carSimulator.simulate();
        ResultView.printWinners(carSimulator.getWinners());
    }
}
