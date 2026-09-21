import domain.Cars;
import domain.RacingGame;
import domain.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = InputView.readCarNames(scanner);
        int rounds = InputView.readValidRounds(scanner);

        RacingGame game = new RacingGame(
                new Cars(names),
                new RandomNumberGenerator()
        );

        runGame(game, rounds);
    }

    private static void runGame(RacingGame game, int rounds) {
        ResultView.printStart();
        game.race(
                rounds,
                () -> ResultView.printCars(game.getCars())
        );
        ResultView.printWinners(game.getWinners());
    }
}
