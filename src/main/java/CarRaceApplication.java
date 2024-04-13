import racingcar.Circuit;
import racingcar.RacingGame;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.ConsoleReader;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceApplication {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(
                new InputView(new ConsoleReader()),
                new OutputView(),
                new Circuit(new RandomNumberGenerator())
        );

        racingGame.run();
    }
}
