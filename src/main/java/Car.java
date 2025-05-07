public class Car {
    private static final int POWER_THRESHOLD_TO_MOVE = 3;

    private final Name name;
    private int position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = 0;
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(final int power) {
        if (POWER_THRESHOLD_TO_MOVE < power) {
            position++;
        }
    }
}
