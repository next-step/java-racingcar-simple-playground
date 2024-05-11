package domain;

import exception.IllegalRandomVariableException;

import java.util.List;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = CarName.form(name);
        this.distance = 0;
    }

    void move() {
        this.distance++;
    }

    public void moveOrStop(int value) {
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
