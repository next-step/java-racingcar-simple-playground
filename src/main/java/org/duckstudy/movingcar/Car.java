package org.duckstudy.movingcar;

import java.util.Random;

public class Car {

    private final String name;
    private long position;

    private final Random random = new Random();

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public long moveMain(){
        int randomValue = makeRandomValue();
        return move(randomValue);
    }

    public int makeRandomValue(){
        return random.nextInt(9);
    }

    public long move(int randomValue) {
        if (randomValue >= 4) {
            return ++position;
        }

        return position;
    }

    public void reset() {
        this.position = 0;
    }
}
