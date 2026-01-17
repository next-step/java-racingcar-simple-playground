package car;

public class MovingCar {

    private static final int THRESHOLD = 4; // 임계값
    private final String name;
    private int location = 0;
    public MovingCar(String name) {
        this.name = name;
    }

    public void move(int randomValue) {
        if (randomValue >= THRESHOLD) {
            forward();
        }
    }

    private void forward() {
        location += 1;
    }

    public int getLocation() {
        return location;
    }
    public String getName() {
        return name;
    }
}