package domain;

import java.util.Random;

public class Car {
    public static final int INITIAL_POSITION = 1; //위치 기본값 상수
    public static final int MOVE_VALUE = 4;//움직임 기준 상수
    private final String name;
    private int position;

    public Car(String name) { //Car 객체 생성
        this.name = name;
        this.position = Car.INITIAL_POSITION;
    }

    public String getNames() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }

    public void move() { //4이상이면 이동(기존의 T/F에서 수정)
        int rndNum = getRndNum();
        if (rndNum >= Car.MOVE_VALUE) {
            position++;
        }
    }

    public int getRndNum() { //랜덤 변수생성(0~9)
        Random random = new Random();
        return random.nextInt(10);
    }
}
