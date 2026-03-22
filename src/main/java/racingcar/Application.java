package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Car> carList = Arrays.stream(InputView.readCarNames())
                .map(String::trim)
                .map(Car::new)
                .toList();

        RacingGame racingGame = new RacingGame(new Cars(carList), new RandomNumberGenerator());

        int tryCount = InputView.readTryCount();

        OutputView.printResultHeader();
        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();
            OutputView.printRoundResult(racingGame.getCars());
        }

        OutputView.printWinners(racingGame.getWinners());
    }
}
