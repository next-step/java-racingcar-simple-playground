import java.util.Random;

public class Car {
    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void move() {
        if(isMovable()) location++;
    }

    private static boolean isMovable() {
        Random random = new Random();

        return random.nextInt(9) + 1 >= 4;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
