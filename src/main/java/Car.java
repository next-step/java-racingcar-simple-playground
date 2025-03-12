public class Car {

    private final NumberGenerator numberGenerator;
    private final String name;
    private int distance;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.distance = 0;
        this.numberGenerator = numberGenerator;
    }

    void move() {
        if (numberGenerator.getRandomNumber() >= 4) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }
}
