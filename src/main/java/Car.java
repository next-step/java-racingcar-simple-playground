public class Car {
    private final String name;
    private int position = 0;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    static boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }

    public void move() {
        position++;
    }

    public boolean isSamePosition(int target) {
        return this.position == target;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}