import racingcar.RacingGame;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RacingCircuit;
import racingcar.infrastructure.RandomNumberGenerator;
import racingcar.infrastructure.ConsoleReader;
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
                new RacingCircuit(generator)
        );

        racingGame.run();
        reader.close();
    }
}
