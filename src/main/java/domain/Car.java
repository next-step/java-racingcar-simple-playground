package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.Utils.validateName;

public final class Car {
    private static final int MOVING_THRESHOLD = 3;
    private static final int NUMBER_LOWER_BOUND = 0;
    private static final int NUMBER_UPPER_BOUND = 10;

    private final String name;
    private final List<Integer> moveHistory;

    public Car(final String name) {
        this.name = validateName(name);
        this.moveHistory = new ArrayList<>();
    }

    private void checkNumberBound(final int number) {
        if (number < NUMBER_LOWER_BOUND || number >= NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException("입력값이 범위를 벗어났습니다.");
        }
    }

    public void moveIfGreaterThan(final int number) {
        checkNumberBound(number);
        int moved = Boolean.compare(number > MOVING_THRESHOLD, false);
        moveHistory.add(moved);
    }

    public void moveIfGreaterThan(final int... numbers) {
        for (int number : numbers) {
            moveIfGreaterThan(number);
        }
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMoveHistory() {
        return moveHistory;
    }
}
