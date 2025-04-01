package domain;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MOVE_THRESHOLD = 4;

    private final NumberGenerateStrategy numberGenerator;

    public RandomMovingStrategy(NumberGenerateStrategy numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean isMovable() {
        return numberGenerator.generate() >= MOVE_THRESHOLD;
    }
}
