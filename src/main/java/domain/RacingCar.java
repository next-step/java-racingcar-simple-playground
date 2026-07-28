package domain;

import java.util.Objects;

public class RacingCar {

    private final String name;
    private int position;

    private static final int MOVE_STATUS = 4;

    public RacingCar(String name, int position) {
        validateName(name);
        validatePosition(position);

        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException();
        }
    }

    private boolean moveReturn(int randomMove) {
        return randomMove >= MOVE_STATUS;
    }

    public void move(int randomMove) {
        if (moveReturn(randomMove)) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
