package domain;

import java.util.Random;

public class RandomGenerator {
    private static final int MAX = 10;
    private static final Random random = new Random();

    //랜덤 숫자 생성 메서드
    public static int getRandomNumber() {
        return random.nextInt(MAX);
    }

}
