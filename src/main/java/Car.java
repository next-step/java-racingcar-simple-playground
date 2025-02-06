import java.util.Random;

public class Car {

    private final Random random;
    private final String name;
    private int position;


    public Car(String name, Random random) {
        this.name = name;
        this.random = random;
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        return random.nextInt(10) >= 4;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
