package domain;

import java.util.Random;

public class RandomGenerator {
    Random random = new Random();

    // 랜덤숫자 반환 메서드
    public int getRandomNumber(){
        return random.nextInt(10);
    }
}
