package racingcar.domain;

import java.util.InputMismatchException;

public class RacingLap { // lap횟수를 입력하면 생성되고, 입력을 controller로부터 넘겨받아서, 검증까지
    private int lapCount;
    public RacingLap(int lapCount) {
        checkLapCount(lapCount);
        this.lapCount = lapCount;
    }

    //lapCount 비즈니스 규칙 설정. 예외처리까지 싹
    //경기 횟수 입력 관련 예외처리 전용 메서드
    private static void checkLapCount(int lapCount) {
        try {
            if (lapCount < 1){
                throw new IllegalArgumentException("횟수는 1회 이상으로 입력해주세요.");
            }
        } catch (InputMismatchException e) {
            System.out.println("횟수는 정수로 입력해주세요.");
        }
    }

    //lapCount getter
    public int getLapCount() {
        return this.lapCount;
    }
}
