package model;

public class Car {
    String name;
    private int position = 0;
    private static final int FORWARD_THRESHOLD = 4;

    public Car(String newName) {
        this.name = newName;
    }

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
