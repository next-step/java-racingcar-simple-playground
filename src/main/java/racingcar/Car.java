package racingcar;

import java.util.Random;

public class Car {
    private String name;
    private int location;

    public Car(String name) {    //생성자
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다."); // 3단계 조건 - "이름은 5자 이하만 가능하다"
        }
        this.name = name;
        this.location = 0;

    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    //랜덤한 숫자를 0-9중에 만드는 함수
    public int makeNum() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public void moveCar(int randomValue) {
        if (randomValue >= 4) {
            location += 1; //한번에 1씩 전진한다고 가정한다..
        }
    }
}

