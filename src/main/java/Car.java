public class Car {

    private static final int MOVABLE_OFFSET = 4;

    private final String name;
    private int position;

    public Car(final String name) {
        this.name = name;
    }

    public void moveForward(final int inputValue) {
        if (inputValue >= MOVABLE_OFFSET) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(final int position) {
        return this.position == position;
    }
}
