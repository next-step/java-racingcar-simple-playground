public class MoveCondition {
    private static final int MOVE_THRESHOLD = 4;

    private final NumberGenerator numberGenerator;

    public MoveCondition(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean isMoveable() {
        int number = numberGenerator.generate();
        return number >= MOVE_THRESHOLD;
    }
}
