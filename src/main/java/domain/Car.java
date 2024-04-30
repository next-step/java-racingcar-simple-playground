package domain;

public class Car {
    private static final int INITIAL_POS = 0;
    private final CarName name;
    private final MoveStrategy strategy;
    private int pos;

    public Car(final String name, final MoveStrategy strategy) {
        this.name = new CarName(name);
        this.strategy = strategy;
        this.pos = INITIAL_POS;
    }

    public void move() {
        if (strategy.canMove()) {
            pos++;
        }
    }

    public String getName() {
        return name.name();
    }

    public int getPos() {
        return pos;
    }
}
