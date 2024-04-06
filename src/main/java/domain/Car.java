package domain;

import java.util.Random;

public class Car {
    private String name;
    private int movingCnt;
    private int rnd;
    private boolean win;

    public Car(String name) {
        this.name = name;
        this.movingCnt = 0;
    }

    public int Moving() {
        Random random = new Random(20);

        rnd = random.nextInt(1, 10);

        if (rnd >= 4) {
            return 1;
        }
        return 0;
    }

    public int getRnd() {
        return this.rnd;
    }

    public void addMovingCnt(int movingCnt) {
        this.movingCnt += movingCnt;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public String getName() {
        return this.name;
    }

    public boolean getWin() {
        return this.win;
    }

    public int getMovingCnt() {
        return this.movingCnt;
    }
}
