public final class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
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
        return number >= 4;
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }
}