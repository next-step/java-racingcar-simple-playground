package service;

import domain.Race;
import domain.RandomNumberGenerator;
import view.OutputView;

public final class RacingCarGame {
    private static final int MIN_TRYCOUNT = 1;

    private final Race race;
    private final RandomNumberGenerator generator;
    private final OutputView outputView;

    public RacingCarGame(Race race, RandomNumberGenerator generator, OutputView outputView) {
        this.race = race;
        this.generator = generator;
        this.outputView = outputView;
    }

    public void play(int tryCount) {
        validateTryCount(tryCount);

        outputView.printStart();
        runAndPrint(tryCount);
        outputView.printWinners(race.cars().winnerNames());
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRYCOUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }

    private void runAndPrint(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            race.cars().moveAll(generator);
            outputView.printRound(race.cars().asList());
        }
    }
}
