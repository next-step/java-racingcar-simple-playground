package domain;

public final class Car {
    private final CarName name;
    private int position;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public void move(RandomNumberGenerator generator) {
        moveBy(generator.generate());
    }

    private void moveBy(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }

    public String name() {
        return name.value();
    }

    public int position() {
        return position;
    }
}
