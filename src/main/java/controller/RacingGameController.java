package controller;

import domain.Car;
import dto.RaceResultInfoDto;
import service.RacingGameService;
import view.RacingGamePlayView;

import java.util.List;
import java.util.Random;

public class RacingGameController {

    private static final int CEILING_OF_RANDOM_GO_FORWARD_DECIDER = 10;

    private final Random random = new Random();
    private final RacingGameService racingGameService = new RacingGameService();
    private final RacingGamePlayView racingGamePlayView = new RacingGamePlayView();

    private final List<Car> cars;
    private final int gameCount;

    public RacingGameController(String inputCarNames, int gameCount) {
        String[] carNames = racingGameService.splitInputCarNames(inputCarNames);
        this.cars = racingGameService.createCarsFromNames(carNames);

        racingGameService.validateGameCount(gameCount);
        this.gameCount = gameCount;
    }

    public void race() {
        racingGamePlayView.printRaceResultHeader();
        printEachCarInformation();

        for (int i = 0; i < gameCount; i++) {
            proceedRace();
            printEachCarInformation();
        }
    }

    public RaceResultInfoDto getRaceResult() {
        int longestMoveDistance = racingGameService.getLongestMoveDistance(cars);
        List<Car> winners = racingGameService.getWinners(cars, longestMoveDistance);

        return RaceResultInfoDto.from(winners);
    }

    private void proceedRace() {
        for (Car car : cars) {
            racingGameService.proceedCar(car, getRandomGoForwardDecider());
        }
    }

    private void printEachCarInformation() {
        for (Car car : cars) {
            String carName = car.getName();
            int moveDistance = car.getMoveDistance();

            racingGamePlayView.printCarInformation(carName, moveDistance);
        }

        racingGamePlayView.printEmptyLine();
    }

    private int getRandomGoForwardDecider() {
        return random.nextInt(CEILING_OF_RANDOM_GO_FORWARD_DECIDER);
    }
}
