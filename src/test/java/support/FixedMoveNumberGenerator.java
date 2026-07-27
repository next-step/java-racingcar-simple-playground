package support;

import domain.MoveNumberGenerator;

public class FixedMoveNumberGenerator implements MoveNumberGenerator {
    private final int number;

    public FixedMoveNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
