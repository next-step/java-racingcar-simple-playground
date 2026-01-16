package racingcar;

public class Car {

    public String name;
    public int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int value) {
        this.position += value;
    }
}
