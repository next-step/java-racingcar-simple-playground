public class Car {
    private final String name;
    private int position;

    private static final int FORWARD_RULE = 4;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(NumberGenerator generator) {
        if (generator.generate() >= FORWARD_RULE) position++;
    }

    public int getPosition() {
        return position;
    }
}
