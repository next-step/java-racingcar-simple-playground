
public class Car {
    String name;
    int position = 0;

    Car(String carName) {
        this.name = carName;
    }
    Car() {
    }

    void moveCar() {
        position += 1;
    }

    void stopCar() {
        position += 0;
    }
}
