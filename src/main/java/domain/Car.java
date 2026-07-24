package domain;
import java.util.Random;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_RANGE = 10;

    Random random = new Random();

    private int location = 0;
    private final String name;

    public Car(String name){
        this.name = name;
    }

    public String getCarName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void move(){
        int number = random.nextInt(RANDOM_RANGE);
        decide(number);
    }

    public void decide(int number) {
        if(number >= MOVE_THRESHOLD){
            location++;
        }
    }

}