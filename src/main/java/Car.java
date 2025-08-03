import java.util.Random;

public class Car {

    private static final int RANDOM_LOWER_BOUND = 0;
    private static final int RANDOM_UPPER_BOUND = 9;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomValue = new Random().nextInt(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND + 1);
        if (randomValue >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void displayPosition() {
        System.out.println(name + " : " + "-".repeat(position));
    }

}