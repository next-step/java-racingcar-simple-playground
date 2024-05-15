package decider;

public interface PositionDecider {

    private void checkRange(int value) {
        if (value > 9 || value < 0) {
            throw new RuntimeException("Invalid range");
        }
    }

    default int getPosition() {
        final int value = generate();
        checkRange(value);
        return value;
    }

    int generate();
}
