import java.util.Random;

public class Car {
    String CarName;
    int location = 0;

    Random moveCar1 () {
        Random random = new Random();
        random.nextInt(10);
        return random;
    }

    int moveCar2 () {
        return (int) (Math.random() * 10);
    }
}
