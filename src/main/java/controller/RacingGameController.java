package controller;

import model.Cars;
import model.NumberGenerator;
import view.InputHandler;
import view.OutputView;

import java.util.List;

public class RacingGameController {
    
    private final NumberGenerator numberGenerator;
    private final InputHandler inputHandler;
    private Cars winners;

    public RacingGameController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        inputHandler = new InputHandler();
    }

    public void run() {
        Cars cars = getJoinCars();
        int tryCount = inputHandler.getTryCount();
        startGame(cars, tryCount);
        finishGame(cars);
    }

    private Cars getJoinCars() {
        List<String> carNames = inputHandler.getCarNames();
        return Cars.create(carNames, numberGenerator);
    }

    private void startGame(Cars cars, int tryCount) {
        OutputView.printGameStartMessage();
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
            OutputView.printRoundResult(cars);
        }
    }

    private void finishGame(Cars cars) {
        winners = cars.getLeadingCars();
        OutputView.printWinners(winners);
    }

    public Cars getWinners() {
        if (winners == null) {
            throw new IllegalStateException("레이싱 게임이 아직 시작되지 않았습니다!");
        }
        return winners;
    }
}
