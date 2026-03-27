package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingGameController {
    public void run() {
        String[] carNames = InputView.readCarNames();
        RacingGame racingGame = createRacingGame(carNames);

        int tryCount = InputView.readTryCount();
        OutputView.printResultHeader();
        playRounds(racingGame, tryCount);
        OutputView.printWinners(racingGame.getWinnerNames());
    }

    private RacingGame createRacingGame(String[] carNames) {
        return new RacingGame(Cars.from(carNames), new RandomNumberGenerator());
    }

    private void playRounds(RacingGame racingGame, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();
            OutputView.printRoundResult(roundResults(racingGame.getCars()));
        }
    }

    private Map<String, Integer> roundResults(List<Car> cars) {
        return cars.stream()
                .collect(Collectors.toMap(
                        Car::getName,
                        Car::getPosition,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }
}
