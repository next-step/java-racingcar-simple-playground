package domain;

public class Car {
    private final CarName name;
    private Position position;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new Position();
    }

    static boolean isMovable(int number) {
        return number >= Car.MOVE_THRESHOLD;
    }

    public void move() {
       this.position = this.position.next();
    }

    public boolean isSamePosition(int target) {
        return this.position.isSameValue(target);
    }

    public String getName() {
        return this.name.getValue();
    }

    public int getPosition() {
        return this.position.getValue();
    }
}
