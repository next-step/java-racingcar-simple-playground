package service;

import domain.*;
import view.OutputView;

import java.util.List;
import java.util.function.Consumer;

public final class RacingCarGame {
    private static final int MIN_TRYCOUNT = 1;

    private final Race race;
    private final RandomNumberGenerator generator;
    private final WinnerSelector winnerSelector;

    public RacingCarGame(Race race, RandomNumberGenerator generator, WinnerSelector winnerSelector) {
        this.race = race;
        this.generator = generator;
        this.winnerSelector = winnerSelector;
    }

    public GameResult play(int tryCount, Consumer<List<Car>> onRoundFinished) {
        validateTryCount(tryCount);

        Cars cars = race.cars();

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(generator);
            onRoundFinished.accept(cars.getCars());
        }

        return new GameResult(winnerSelector.select(cars));
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRYCOUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }

    public record GameResult(List<String> winners) {
    }
}
