package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import exception.TryCountOutOfRangeException;
import util.NumberProvider;

public class Game {

    private final CarGroup carGroup;
    private final int tryCount;

    public Game(String carNames, int tryCount, NumberProvider numberProvider) {
        validateTryCountIsPositive(tryCount);
        this.carGroup = new CarGroup(createCars(carNames), numberProvider);
        this.tryCount = tryCount;
    }

    private List<Car> createCars(String carNames) {
        return Arrays.stream(carNames.split(","))
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private void validateTryCountIsPositive(int tryCount) {
        if (tryCount < 1) {
            throw new TryCountOutOfRangeException("라운드는 1 이상이어야 합니다.");
        }
    }

    public void play() {
        for (int i = 0; i < tryCount; i++) {
            carGroup.moveCars();
        }
    }

    public List<Car> getWinners() {
        return carGroup.getFarthestCars();
    }

    public CarGroup getCarGroup() {
        return carGroup;
    }
}
