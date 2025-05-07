import strategy.MoveStrategy;

public class Car {
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

    public void moveForward(final MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            position++;
        }
    }
}
