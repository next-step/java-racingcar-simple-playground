package controller;

import domain.Car;
import global.InputView;
import service.RacingGameService;

import java.util.List;

public class RacingGameController {
    RacingGameService racingGameService = new RacingGameService();

    public void racingGame() {
        String inputNames = "";
        int inputGameCount = 0;

        try(InputView inputView = new InputView()) {
            inputNames = inputView.readLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            inputGameCount = inputView.readInt("시도할 회수는 몇회인가요?");

        } catch (Exception e) {
            e.printStackTrace();
        }

        int gameCount = validateInputCount(inputGameCount);
        String[] carNames = splitCarNames(inputNames);

        for (String carName : carNames) {
            validateInputName(carName);
        }
        List<Car> cars = Car.getInstancesByNames(carNames);

        printEmptyLine();

        racingGameService.playRacingGame(cars, gameCount);

        int LongestDistance = racingGameService.getLongestMoveDistance(cars);
        racingGameService.printWinners(LongestDistance, cars);
    }

    private String[] splitCarNames(String names) {
        return names.split(",");
    }

    private void validateInputName(String inputName) {
        if (isIllegalInputName(inputName)) {
            throw new IllegalArgumentException("name is illegal");
        }
    }

    private int validateInputCount(int inputCount) {
        if (isIllegalInputCount(inputCount)) {
            throw new IllegalArgumentException("number is illegal");
        }

        return inputCount;
    }

    private boolean isIllegalInputCount(int count) {
        return count <= 0;
    }

    private boolean isIllegalInputName(String inputName) {
        return inputName == null || inputName.isEmpty() || inputName.equals(" ") || isLongerThan5(inputName);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private boolean isLongerThan5(String str) {
        return str.length() > 5;
    }
}
