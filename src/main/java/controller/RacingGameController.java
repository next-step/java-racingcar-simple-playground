package controller;

import domain.Car;
import service.RacingGameService;

import java.util.List;
import java.util.Scanner;

public class RacingGameController {
    RacingGameService racingGameService = new RacingGameService();
    Scanner scanner = new Scanner(System.in);

    public void racingGame() {
        String inputNames = inputNames();
        int gameCount = inputGameCount();

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

    private boolean isIllegalInputName(String inputName) {
        return inputName == null || inputName.isEmpty() || inputName.equals(" ") || isLongerThan5(inputName);
    }

    private void validateInputName(String inputName) {
        if (isIllegalInputName(inputName)) { // 2. 검증하기
            throw new IllegalArgumentException("name is illegal");
        }
    }

    private String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputNames = scanner.nextLine();

        return inputNames;
    }

    private int inputGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int count = scanner.nextInt();

        if (isIllegalInputGameCount(count)) {
            throw new IllegalArgumentException("number is illegal");
        }

        return count;
    }

    private boolean isIllegalInputGameCount(int count) {
        return count <= 0;
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private boolean isLongerThan5(String str) {
        return str.length() > 5;
    }
}
