package domain;

import exception.IllegalRandomVariableException;

import java.util.List;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    void move() {
        this.distance++;
    }

    public void moveOrStop(int value) {

        if(value < 0 || value > 9){
            throw new IllegalRandomVariableException("숫자가 예상 범위를 초과합니다.");
        }

        if(value >= 4 && value <=9){
            move();
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName(){
        return name;
    }
}
