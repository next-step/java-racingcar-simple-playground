package domain;

public class Car {

    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = 0;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            this.position++;
        }
    }

    public String getName() {
        return name.name();
    }

    public int getPosition() {
        return position;
    }
}
