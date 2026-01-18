package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameManager;
import racingcar.view.ConsoleView;

public class Application {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        ConsoleView consoleView = new ConsoleView();

        List<String> carNames = consoleView.readCarNames();
        gameManager.setCars(carNames);

        int attempt = consoleView.readAttempt();
        consoleView.printRacePrefix();

        for (int i = 0; i < attempt; i++) {
            gameManager.raceOneRound();
            consoleView.printRoundResult(gameManager.getCars());
        }

        List<Car> winCars = gameManager.getWinCars(gameManager.getCars());
        consoleView.printWinCars(winCars);
    }
}
