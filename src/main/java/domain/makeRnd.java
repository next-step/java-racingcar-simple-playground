package domain;

import java.util.Random;

public class makeRnd {
    public int getRndNum() { //랜덤 변수생성(0~9)
        Random random = new Random();
        return random.nextInt(10);
    }
}
