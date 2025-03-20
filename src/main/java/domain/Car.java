package domain;

public class Car {

    public static final int MOVE_FORWARD_MIN = 4;

    private String name;
    private int position;

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

    public void moveCar(int random) {
        if (random >= MOVE_FORWARD_MIN) {
            position += 1;
        }
    }
}
