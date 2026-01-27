package domain;

import view.OutputView;

import java.util.List;

public final class RacingCarGame {
    private static final int MIN_TRYCOUNT = 1;

    private final Race race;
    private final RandomNumberGenerator generator;

    public RacingCarGame(Race race, RandomNumberGenerator generator) {
        this.race = race;
        this.generator = generator;
    }

    public List<RoundResult> play(int tryCount) {
        validateTryCount(tryCount);
        return race.run(tryCount, generator);
    }

    public List<String> winners() {
        return race.cars().winnerNames();
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRYCOUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }
}
