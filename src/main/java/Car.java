import java.util.Random;

public class Car {
    private String name = "";
    private Random random = new Random();
    private int numberOfMoves = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }
    public void move() {
        if (random.nextInt(10) >= 4) {
            ++numberOfMoves;
        }
    }
}
