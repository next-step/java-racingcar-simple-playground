package CarGame2;

public class Car {

    private static final int MIN_SPEED = 4;
    private final String name;
    private final Generator generator;

    private int position = 0;
    private int speed;

    public Car(String name, Generator generator) {
        validateGenerator(generator);
        this.name = name;
        this.generator = generator;
    }

    private void validateGenerator(Generator generator) {
        if (generator == null) {
            throw new IllegalArgumentException("Generator가 null입니다. 올바른 Generator를 주입해주세요.");
        }
    }

    public void move() {
        speed = generator.generate();
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
