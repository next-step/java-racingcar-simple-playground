public class FixedMovement implements CarMovement {
    private final int number;

    public FixedMovement(int number) {
        this.number = number;
    }

    public int generate() {
        return this.number;
    }
}