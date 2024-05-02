public class Car {

    private String name;
    private static final int MOVABLE_BOUND = 4;

    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int value) {
        if (isMovable(value)) {
            position++;
        }
    }

    private boolean isMovable(int value) {
        checkRange(value);
        return value >= MOVABLE_BOUND;
    }

    private void checkRange(int value) {
        if (value > 9 || value < 0) {
            throw new RuntimeException("Invalid range");
        }
    }

    public int getPosition() {
        return position;
    }
}
