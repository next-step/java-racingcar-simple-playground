import controller.RacingGameController;
import domain.Car;
import view.RacingGameInputView;
import view.RacingGameResultView;

import java.util.List;
import java.util.Scanner;

public class RacingGameApplication {

    private static final Scanner scanner = new Scanner(System.in);
    private static final RacingGameInputView racingGameInputView = new RacingGameInputView(scanner);
    private static final RacingGameController racingGameController = new RacingGameController();
    private static final RacingGameResultView racingGameResultView = new RacingGameResultView();

    public static void main(String[] args) {
        String carNames = racingGameInputView.getCarNames();
        int gameCount = racingGameInputView.getGameCount();
        racingGameInputView.printEmptyLine();

        List<Car> cars = racingGameController.race(carNames, gameCount);
        List<Car> winners = racingGameController.getWinners(cars);
        racingGameResultView.printWinners(winners);

        scanner.close();
    }
}
