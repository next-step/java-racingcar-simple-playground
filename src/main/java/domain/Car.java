package domain;

import java.util.Random;

public class Car {
    private String carName;
    private int movingCnt;

    public Car(String name) {
        this.carName = name;
        this.movingCnt = 0;
    }

    public void moving() {
        Random random = new Random();

        if (random.nextInt(1, 10) >= 4) {
            this.movingCnt += 1;
        }

    }

    public String getCarName() {
        return this.carName;
    }

    public int getMovingCnt() {
        return this.movingCnt;
    }
}
