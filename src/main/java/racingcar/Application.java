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
        String[] carNames = InputView.readCarNames();
        int tryCount = InputView.readTryCount();

        RacingGame racingGame = createRacingGame(carNames);

        OutputView.printResultHeader();
        playRounds(racingGame,tryCount);
        OutputView.printWinners(racingGame.getWinners());
    }

    private static RacingGame createRacingGame(String[] carNames) {
        return new RacingGame(new Cars(createCars(carNames)), new RandomNumberGenerator());
    }

    private static List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    private static void playRounds(RacingGame racingGame, int tryCount){
        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();
            OutputView.printRoundResult(racingGame.getCars());
        }
    }
}
