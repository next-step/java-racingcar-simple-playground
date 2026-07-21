
public class Car {
    String Name;
    int position = 0;

    Car(String carName) {
        this.Name = carName;
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
