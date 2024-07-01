package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.util.RandomGeneratorImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public List<Car> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
            .map(Car::new)
            .toList();
    }

    public void run() {
        String carNames = InputView.inputCarNames();
        int round = InputView.inputRound();

        List<Car> cars = parseCarNames(carNames);

        RacingGame game = new RacingGame(cars, new RandomGeneratorImpl());
        game.start(round);

        OutputView.printWinners(game.getWinners());
    }
}
