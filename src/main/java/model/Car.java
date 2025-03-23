package model;

public class Car {

    private static final int MOVING_THRESHOLD = 4;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int random) {
        if (random >= MOVING_THRESHOLD) {
            this.position += 1;
        }
    }

    public boolean hasSamePosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
