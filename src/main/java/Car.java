public class Car {
    private final String name;
    private int position = 0;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        position++;
    }

    public boolean isSamePosition(int target) {
        return this.position == target;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}