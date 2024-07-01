import java.util.Random;

public class Car {
    private final String name;
    private final Random random;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        this.random = new Random(System.currentTimeMillis());
    }

    public void move() {
        if (random.nextInt(10) % 10 < 4) return;

        ++position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
