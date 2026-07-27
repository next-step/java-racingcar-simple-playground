package domain;

import java.util.*;


public class RacingCar {

    String name;
    int position;

    private static final int MOVE_STATUS = 4;

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public boolean moveReturn(int randomMove) {
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
