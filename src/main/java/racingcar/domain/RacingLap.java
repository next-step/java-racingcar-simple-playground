package racingcar.domain;

import java.util.InputMismatchException;

public class RacingLap {
    public static final int MIN_RACINGGAME_LAP_COUNT = 1;
    private final int lapCount;

    public RacingLap(int lapCount) {
        checkLapCount(lapCount);
        this.lapCount = lapCount;
    }

    private void checkLapCount(int lapCount) {
        try {
            if (lapCount < MIN_RACINGGAME_LAP_COUNT) {
                throw new IllegalArgumentException("횟수는 1회 이상으로 입력해주세요.");
            }
        } catch (InputMismatchException e) {
            System.out.println("횟수는 정수로 입력해주세요.");
        }
    }

    public int getLapCount() {
        return this.lapCount;
    }
}
