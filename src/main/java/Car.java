public class Car {
    private final String name;
    private int position;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 비워둘 수 없습니다.");
        }

        if (name.length() < 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }

        this.name = name;
    }

    static boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }

    public void move() {
        position++;
    }

    public boolean isSamePosition(int target) {
        return this.position == target;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
