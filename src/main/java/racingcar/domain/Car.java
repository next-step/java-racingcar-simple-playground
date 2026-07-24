package racingcar.domain;

import java.util.Random;

public class Car implements MakeNumStrategy {
    private String name;
    private int location;

    public Car(String name) {    //생성자
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public void moveCar(int randomValue) {
        if (randomValue >= 4) {
            location += 1; //한번에 1씩 전진한다고 가정한다..
        }
    }

    //랜덤한 숫자를 0-9중에 만드는 메서드
    @Override
    public int makeNum() {
        Random random = new Random();
        return random.nextInt(10);
    }
}

