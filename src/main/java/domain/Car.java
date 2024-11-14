package domain;

import java.util.*;

public class Car {
    //// 필드
    private final String name;
    private int distance;

    //// 생성자
    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    //// 메소드
    // 자동자 움직이기
    public void move() {
        Random random = new Random();
        int randomValue = random.nextInt(10);
        if (randomValue >= 4) {
            this.distance++;
        }
    }

    // distance 반환
    public int getDistance() {
        return this.distance;
    }

    // name 반환
    public String getName() {
        return this.name;
    }
}
