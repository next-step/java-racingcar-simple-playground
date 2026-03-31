package domain;

public class Car {
    private final String name;
    private static final int MOVE_THRESHOLD = 4;
    private static final String MOVE_STATUS_MARKER = "-";
    private final RandomGenerator randomGenerator;
    private int totalMoveCount = 0;

    public Car(String name, RandomGenerator randomGenerator) {
        this.name = name;
        this.randomGenerator = randomGenerator;
    }

    public void move() {
        int rand = this.randomGenerator.generate();
        if(rand >= MOVE_THRESHOLD) {
            this.totalMoveCount += 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getTotalMoveCount() {
        return this.totalMoveCount;
    }

    public String getMoveStatus() {
        move();
        return MOVE_STATUS_MARKER.repeat(totalMoveCount);
    }

    public boolean isWinner(int highestMoveCount) {
        return this.totalMoveCount >= highestMoveCount;
    }
}
