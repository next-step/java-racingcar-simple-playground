import java.util.Random;

public class Car {
    private final String name;
    private int location;
    private final Random random;

    public Car(String name, Random random) {
        this.name = name;
        this.random = random;
        this.location = 0;
    }

    public void move() {
        if(isMovable()) location++;
    }

    private boolean isMovable() {
        return random.nextInt(9) + 1 >= 4;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
