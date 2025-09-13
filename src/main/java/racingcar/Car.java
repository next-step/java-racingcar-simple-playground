package racingcar;

import java.util.Random;

public class Car {
    String carName;
    int carPosition = 0;
    private static final int MOVE_STANDARD = 4;

    public Car (String name){
        this.carName = name;
    }

    public void move (){

        Random random = new Random();
        int randomNumber = random.nextInt(10);
        if (randomNumber >= MOVE_STANDARD){
            carPosition++;
        }
    }

    public int getCarPosition(){
        return carPosition;
    }

    public String getCarName(){
        return carName;
    }
}