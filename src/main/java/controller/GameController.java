package controller;

import domain.car.Car;
import domain.game.RacingGame;
import domain.generator.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final ResultView resultView;

    public GameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        final var carNames = inputView.readCarNames();
        final var tryCount = inputView.readTryCount();

        validateTryCount(tryCount);

        List<Car> cars = createCars(carNames);
        RacingGame racingGame = new RacingGame(cars, new RandomNumberGenerator());

        resultView.printResultMessage();

        play(racingGame, tryCount);

        resultView.printWinners(racingGame.findWinners());
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void validateTryCount(int tryCount) {
        if(tryCount <= 0){
            throw new IllegalArgumentException("시도 횟수는 1이상만 가능합니다.");
        }
    }

    private void play(RacingGame racingGame, int tryCount) {
        for(int i = 0; i < tryCount; i++){
            racingGame.run();
            resultView.printCars(racingGame.getCars());
        }
    }
}
