package racingcar.controller;

import racingcar.model.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameManageController {
    private final ExceptionHandler exceptionHandler;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;

    private Cars playerCars;
    private int tryCount;

    public GameManageController() {
        exceptionHandler = new ExceptionHandler();
        inputView = new InputView();
        outputView = new OutputView();
        inputValidator = new InputValidator();
    }

    public void readyRacingGame() {
        List<Car> carList = repeatUntilSuccessName();
        playerCars = new Cars(carList);
        tryCount = repeatUntilNum();
    }

    public void runRacingGame(NumberGenerator numberGenerator) {
        outputView.printExecutionResultMessage();
        printRoundResult(playerCars);

        playGame(playerCars, numberGenerator, tryCount);

        outputView.printWinners(playerCars.getWinners());
    }

    private List<Car> repeatUntilSuccessName() {
        return exceptionHandler.run(() -> {
            outputView.printNameGuide();
            String inputNames = inputView.readInput();
            List<String> nameList = inputCarsName(inputNames);
            return inputValidator.validateCarName(nameList);
        });
    }

    private int repeatUntilNum() {
        return exceptionHandler.run(() -> {
            outputView.printCountGuide();
            String input = inputView.readInput();
            return inputValidator.validatePlayCount(input);
        });
    }

    private void playGame(Cars playerCars, NumberGenerator numberGenerator, int playCount) {
        for (int i = 0; i < playCount; i++) {
            playerCars.moveCars(numberGenerator);
            printRoundResult(playerCars);
            outputView.printEmptyLine();
        }
    }

    private List<String> inputCarsName(String inputNames) {
        return List.of(inputNames.split(","));
    }

    private void printRoundResult(Cars playerCars) {
        List<CarStatus> carStatuses = playerCars.getCarsStatus();
        for (CarStatus carStatus : carStatuses) {
            outputView.printCurrentPosition(carStatus.name(), carStatus.position());
        }
    }
}
