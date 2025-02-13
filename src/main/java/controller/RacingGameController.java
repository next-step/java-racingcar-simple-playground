package controller;

import domain.Car;
import global.InputView;
import service.RacingGameService;

import java.util.List;

public class RacingGameController {
    private static final String DEFAULT_NAME_DELIMITER = ",";

    RacingGameService racingGameService = new RacingGameService();

    public void racingGame() {
        String inputNames = ""; // scope problem
        int inputGameCount = 0;

        try(InputView inputView = new InputView()) {
            inputNames = inputView.readLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            inputGameCount = inputView.readInt("시도할 회수는 몇회인가요?");

        } catch (Exception e) {
            e.printStackTrace();
        }

        int gameCount = validateInputCount(inputGameCount);
        String[] splitCarNames = splitCarNames(inputNames);

        List<Car> cars = Car.getInstancesByNames(splitCarNames);

        printEmptyLine();

        racingGameService.playRacingGame(cars, gameCount);

        int longestDistance = racingGameService.getLongestMoveDistance(cars);
        racingGameService.printWinners(longestDistance, cars);
    }

    private String[] splitCarNames(String names) {
        return names.split(DEFAULT_NAME_DELIMITER);
    }

    private int validateInputCount(int inputCount) {
        if (isIllegalInputCount(inputCount)) {
            throw new IllegalArgumentException("inputCount can't be less than 0");
        }

        return inputCount;
    }

    private boolean isIllegalInputCount(int count) {
        return count <= 0;
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
