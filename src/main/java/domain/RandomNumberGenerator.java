package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator { // 인터페이스 구현하는 클래스 선언

    private static final int RANDOM_BOUND = 10;

    private final Random random = new Random(); // 랜덤 숫자 생성할 객체 만듬

    @Override
    public int generate() {
        return random.nextInt(RANDOM_BOUND); // 랜덤 숫자 반환
    }
}
