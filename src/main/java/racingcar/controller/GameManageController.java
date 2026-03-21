package racingcar.controller;

import racingcar.model.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameManageController {
    private final ExceptionHandler exceptionHandler;
    private final InputView inputView;
    private final OutputView outputView;

    private Cars playerCars;
    private int tryCount;

    public GameManageController() {
        exceptionHandler = new ExceptionHandler();
        inputView = new InputView();
        outputView = new OutputView();
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
            return validateCarName(nameList);
        });
    }

    private int repeatUntilNum() {
        return exceptionHandler.run(() -> {
            outputView.printCountGuide();
            String input = inputView.readInput();
            return validatePlayCount(input);
        });
    }

    private void playGame(Cars playerCars, NumberGenerator numberGenerator, int playCount) {
        List<CarStatus> carStatus = playerCars.getCarsStatus();
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

    private List<Car> validateCarName(List<String> nameList) {
        validateNameCount(nameList);
        return nameList.stream()
                .map(Car::new)
                .toList();
    }

    private void validateNameCount(List<String> carNameList) {
        if (carNameList.size() <= 1) {
            throw new IllegalArgumentException("게임 플레이에는 2명 이상이 필요합니다.");
        }
    }

    private int validatePlayCount(String inputTryCount) {
        validateNumber(inputTryCount);
        validateCountRange(inputTryCount);
        return Integer.parseInt(inputTryCount);
    }

    private void validateNumber(String inputTryCount) {
        try {
            Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }

    private void validateCountRange(String inputTryCount) {
        if (Integer.parseInt(inputTryCount) <= 0) {
            throw new IllegalArgumentException("1번 이상의 시도를 해야 합니다.");
        }
    }
}
