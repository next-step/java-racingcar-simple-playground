import java.util.Random;

public class Car {
    String CarName;
    int location = 0;

    public Car(String carName) {
        CarName = carName;
    }

    void moveCar () {
        int n = (int) (Math.random() * 10);
        if (n > 3) {
            location += 1;
        }
    }
}
