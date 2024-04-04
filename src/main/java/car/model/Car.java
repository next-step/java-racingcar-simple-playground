package car.model;

public class Car {
    private final String name;
    private int position = 0;
    private  final static int FORWARD_NUMBER = 4;


    public Car(String name) {
        this.name = name;
    }

    public void move() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int number = randomNumberGenerator.generate();
        if (number>= FORWARD_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
