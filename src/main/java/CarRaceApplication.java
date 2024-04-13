import racingcar.Circuit;
import racingcar.RacingGame;
import racingcar.generator.NumberGenerator;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.ConsoleReader;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.Reader;

public class CarRaceApplication {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        NumberGenerator generator = new RandomNumberGenerator();

        RacingGame racingGame = new RacingGame(
                new InputView(reader),
                new OutputView(),
                new Circuit(generator)
        );

        racingGame.run();
        reader.close();
    }
}
