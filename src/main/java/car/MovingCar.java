package car;

public class MovingCar {

    private static final int THRESHOLD = 4; // 임계값
    private final String name;
    private int location = 0;
    public MovingCar(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
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