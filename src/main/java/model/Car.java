package model;

public class Car {

    final int MOVABLE_NUMBER = 4;
    String name;
    int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVABLE_NUMBER) {
            ++position;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
