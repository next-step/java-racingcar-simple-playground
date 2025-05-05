public class Car {
    private final String name;
    private int position;

    public Car(final String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void canMove(int randomValue) {
        if (randomValue > 3) {
            position++;
        }
    }
}
