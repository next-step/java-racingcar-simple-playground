package racingcar;

import java.util.Random;

public class RandomNumber {

    private final Random randomNumber = new Random(); //굳이 변수선언 안하고 한방에 넣어도 되겠다는 생각?

    public int getRandomNumber() {
        return randomNumber.nextInt(10); // 0~9까지 랜덤숫자를 생성하기.
    }

}
