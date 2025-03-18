package CarGame2;

public class Car {

    private static final int MIN_SPEED = 4;
    private final String name;
    private final Generator Generator;

    private int position = 0;
    private int speed;

    public Car(String name, Generator randomGenerator) {
        this.name = name;
        this.Generator = randomGenerator;
    }

    public void move() {
        speed = Generator.generate();
        if (speed >= MIN_SPEED) {
            position += speed;
        }
    }

    public int getPosition() {
        return position;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
}
