public class RoundCount {
    private int roundCount;

    public RoundCount(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 한다.");
        }
        roundCount = value;
    }

    public int getValue() {
        return roundCount;
    }
}
