package racingcar.domain;

import java.util.InputMismatchException;

public class RacingLap {
    private int lapCount;
    public RacingLap(int lapCount) {
        checkLapCount(lapCount);
        this.lapCount = lapCount;
    }

    private static void checkLapCount(int lapCount) {
        try {
            if (lapCount < 1){
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
