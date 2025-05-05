package domain;

public class Position {
    public static final String INVALID_POSITION_ERROR = "[ERROR] 위치는 음수일 수 없습니다.";
    private static final int MIN_POSITION = 0;
    private static final int STEP = 1;

    private final int value;

    public Position(int value) {
        if (value < MIN_POSITION) {
            throw new IllegalArgumentException(INVALID_POSITION_ERROR);
        }
        this.value = value;
    }

    public Position forward() {
        return new Position(this.value + STEP);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position other = (Position) obj;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}
