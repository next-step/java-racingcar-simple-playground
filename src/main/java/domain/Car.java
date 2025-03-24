package domain;

public class Car {

    private static final int CRITICAL_NUMBER_TO_MOVE = 4;

    private final Name name;
    private int distance;
    private final NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = Name.from(name);
        this.distance = 0;
        this.numberGenerator = numberGenerator;
    }

    public void move() {
        if (numberGenerator.generateNumber() >= CRITICAL_NUMBER_TO_MOVE) {
            distance++;
        }
    }

    public boolean hasSamePosition(int position) {
        return distance == position;
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance;
    }

}
