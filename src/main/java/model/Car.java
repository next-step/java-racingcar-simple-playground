package model;

public class Car {
    String name;
    int position;

    public Car(String name) {
        this.name  = name;
        this.position = 0;
    }

    public int move(int value) {
        if (value >= 4) {
            this.position++;
        }

        return this.position;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
