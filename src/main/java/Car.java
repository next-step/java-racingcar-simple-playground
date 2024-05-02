public class Car {

    private static final int MOVE_AVAILABLE_VALUE = 4;

    private final String name;
    private int position;
    private final MoveStrategy moveStrategy;

    public Car(final String name, final MoveStrategy moveStrategy) {
        this.name = name;
        this.position = 0;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.getNumber() >= MOVE_AVAILABLE_VALUE) {
            position++;
        }
    }

    public boolean isWinner(int winnerPosition) {
        return position == winnerPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
