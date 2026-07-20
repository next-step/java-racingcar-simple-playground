import java.util.Random;

public class Car {
    String Name;
    int position = 0;

    Car(String carName) {
        this.Name = carName;
    }
    Car() {
    }

    int setNum() {
        Random random = new Random();
        return random.nextInt(10);
    }

    void moveCar() {
        position += 1;
    }

    void stopCar() {
        position += 0;
    }
}
