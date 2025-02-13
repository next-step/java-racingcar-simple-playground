package controller;

import domain.Car;
import service.RacingGameService;
import view.RacingGamePlayView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameController {

    private final RacingGameService racingGameService = new RacingGameService();
    private final RacingGamePlayView racingGamePlayView = new RacingGamePlayView();

    public List<Car> race(String inputCarNames, int gameCount) {
        String[] carNames = racingGameService.splitInputCarNames(inputCarNames);
        List<Car> cars = getCarsFromNames(carNames);

        racingGamePlayView.informWillPrintRaceResult();
        racingGamePlayView.printCarStatuses(cars);

        for (int i = 0; i < gameCount; i++) {
            racingGameService.proceedRace(cars);
            racingGamePlayView.printCarStatuses(cars);
        }

        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners(List<Car> cars) {
        int longestMoveDistance = racingGameService.getLongestMoveDistance(cars);
        List<Car> winners = racingGameService.getWinners(cars, longestMoveDistance);

        return Collections.unmodifiableList(winners);
    }

    private List<Car> getCarsFromNames(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(Car.from(name));
        }

        return Collections.unmodifiableList(cars);
    }
}
