package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import exception.RoundOutOfRangeException;
import util.RandomNumberProvider;
import view.OutputView;

public class Game {

    private final CarGroup carGroup;
    private final int round;

    public Game(String carNames, int round) {
        validateRoundIsPositive(round);
        this.carGroup = new CarGroup(createCars(carNames), new RandomNumberProvider());
        this.round = round;
    }

    private List<Car> createCars(String carNames) {
        return Arrays.stream(carNames.split(","))
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private void validateRoundIsPositive(int round) {
        if (round < 1) {
            throw new RoundOutOfRangeException("라운드는 1 이상이어야 합니다.");
        }
    }

    public void play() {
        OutputView.outputStart();
        for (int i = 0; i < round; i++) {
            carGroup.moveCars();
            OutputView.outputCarsMovement(carGroup);
        }
        OutputView.outputCarsMovement(carGroup);
    }

    public List<Car> getWinners() {
        return carGroup.getFarthestCars();
    }
}
