package domain;

public class Car {
    private String name;
    private int distance = 0;
    private final int MOVE_STANDARD_NUMBER = 4;

    public Car(String name){
        this.name = name;
    }

    public void tryMoveByNumber(int number){
        if(number >= MOVE_STANDARD_NUMBER){
            move();
        }
    }

    private void move(){
        distance+=1;
    }

    public int getDistance(){
        return distance;
    }

    public String getName(){
        return name;
    }
}
