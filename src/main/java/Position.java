public class Position {
    private final int value;

    public Position() {
        this.value = 0;
    }

    private Position(int value) {
        this.value = value;
    }

    public Position next() {
        return new Position(value + 1);
    }

    public boolean isSameValue(int target) {
        return value == target;
    }

    public int getValue() {
        return value;
    }
}
