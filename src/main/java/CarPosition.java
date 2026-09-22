public class CarPosition {
    private int position;

    public CarPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치를 음수로 설정 불가");
        }
        this.position = position;
    }

    public void move() {
        position++;
    }

    public int getLargerPosition(int otherPosition) {
        return Math.max(position, otherPosition);
    }

    public boolean isSamePosition(int otherPosition) {
        return position == otherPosition;
    }

    public int getValue() {
        return position;
    }
}
