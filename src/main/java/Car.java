import java.util.Random;

public class Car {
    private static final int MOVEMENT_THRESHOLD = 4;
    private final String name;
    private int location;

    public Car(String name){
        this.name = name;
        this.location = 0;
    }

    public void move(int number){
        if(number >= MOVEMENT_THRESHOLD){
            this.location += 1;
        }
    }

    public void tryMove(){
        Random random = new Random();
        int randomInt = random.nextInt(10);
        move(randomInt);
    }

    public int getLocation(){
        return this.location;
    }

    public String getName() {
        return this.name;
    }
}
