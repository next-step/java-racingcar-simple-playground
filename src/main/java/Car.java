import java.util.Random;

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

    void moveOrStop(int value) {
        if(value >= 4 && value <=9){
            move();
        }
    }

    public int getDistance() {
        return distance;
    }
}
