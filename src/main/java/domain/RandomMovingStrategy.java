package domain;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        final RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        return numberGenerator.generate() >= MOVE_THRESHOLD;
    }
}
