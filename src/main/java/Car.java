public final class Car {
    private final CarName name;
    private int position;

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
        return number >= 4;
    }

    public String name() {
        return name.value();
    }

    public int position() {
        return position;
    }
}