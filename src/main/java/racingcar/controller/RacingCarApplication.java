package racingcar.controller;

import java.util.List;
import java.util.Random;
import racingcar.domain.Car;
import racingcar.domain.GameManager;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

    private final Random random;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarApplication(Random random, InputView inputView, OutputView outputView) {
        this.random = random;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void race() {
        outputView.printInputRacingCarName();
        List<String> carNames = inputView.readCarNames();

        MoveStrategy moveStrategy = new RandomMoveStrategy(random);
        GameManager gameManager = new GameManager(carNames, moveStrategy);

        outputView.printInputAttempt();
        int attempt = inputView.readAttempt();
        outputView.printRacePrefix();

        for (int i = 0; i < attempt; i++) {
            gameManager.raceOneRound();
            outputView.printRoundResult(gameManager.getCars());
        }

        List<Car> winCars = gameManager.getWinCars();
        outputView.printWinCars(winCars);
    }
}
