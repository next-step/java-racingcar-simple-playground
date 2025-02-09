import java.util.List;
import java.util.Scanner;

import domain.Car;
import domain.Game;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(final String... args) {
        final String carNames = InputView.inputCarNames();
        final int round = InputView.inputRound();

        final Game game = new Game(carNames, round);
        game.play();
        OutputView.outputWinner(game.getWinners());
    }
}
