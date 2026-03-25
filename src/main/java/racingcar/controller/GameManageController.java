package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Car;
import racingcar.model.NumberGenerator;
import racingcar.dto.CarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

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
        }
    }

    private List<String> inputCarsName(String inputNames) {
        List<String> splitList = List.of(inputNames.split(","));
        return splitList.stream()
                .map(String::strip)
                .collect(Collectors.toList());
    }

    private void printRoundResult(Cars playerCars) {
        List<CarStatus> carStatuses = playerCars.getCarsStatus();
        for (CarStatus carStatus : carStatuses) {
            outputView.printCurrentPosition(carStatus.name(), carStatus.position());
        }
        outputView.printEmptyLine();
    }
}
