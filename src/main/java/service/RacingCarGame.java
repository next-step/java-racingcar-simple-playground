package service;

import domain.*;
import view.OutputView;

import java.util.List;

public final class RacingCarGame {
    private static final int MIN_TRYCOUNT = 1;

    private final Race race;
    private final RandomNumberGenerator generator;
    private final WinnerSelector winnerSelector;
    private final OutputView outputView;

    public RacingCarGame(Race race,
                         RandomNumberGenerator generator,
                         WinnerSelector winnerSelector,
                         OutputView outputView) {
        this.race = race;
        this.generator = generator;
        this.winnerSelector = winnerSelector;
        this.outputView = outputView;
    }


    public List<String> play(int tryCount) {
        validateTryCount(tryCount);

        outputView.printStart();

        Cars cars = race.cars();
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(generator);
            outputView.printRound(cars.getCars());
        }

        List<String> winners = winnerSelector.select(cars);
        outputView.printWinners(winners);
        return winners;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRYCOUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }
}
