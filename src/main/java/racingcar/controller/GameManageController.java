package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Car;
import racingcar.model.NumberGenerator;
import racingcar.dto.CarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GameManageController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;

    private Cars playerCars;
    private int tryCount;

    public GameManageController(InputView inputView, OutputView outputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    public void readyRacingGame() {
        List<Car> carList = repeatUntilSuccessName();
        playerCars = new Cars(carList);
        tryCount = repeatUntilNum();
    }

    public void runRacingGame(NumberGenerator numberGenerator) {
        outputView.printExecutionResultMessage();

        playGame(playerCars, numberGenerator, tryCount);

        printRoundResult(playerCars);
        outputView.printWinners(playerCars.getWinners());
    }

    private <T> T retryUntilSuccess(Supplier<T> callback) {
        while (true) {
            try {
                return callback.get();
            } catch (IllegalArgumentException exception) {
               outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private List<Car> repeatUntilSuccessName() {
        return retryUntilSuccess(() -> {
            outputView.printNameGuide();
            String inputNames = inputView.readCarNames();
            List<String> nameList = inputCarsName(inputNames);
            return inputValidator.validateCarName(nameList);
        });
    }

    private int repeatUntilNum() {
        return retryUntilSuccess(() -> {
            outputView.printCountGuide();
            String input = inputView.readTryCount();
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
