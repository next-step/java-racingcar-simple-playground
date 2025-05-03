public class Car {
    private static final int INITIAL_POSITION = 0;

    private final Name name;
    private Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position(INITIAL_POSITION);
    }

    public void move(MoveCondition condition) {
        if (condition.isMoveable()) {
            position = position.forward();
        }
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }
}
