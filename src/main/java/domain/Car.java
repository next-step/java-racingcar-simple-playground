package domain;

public class Car {
    private String name;
    private int position = 0;

    public Car(String carName) {
        this.name = carName;
    }

    public void moveCar() {
        position += 1;
    }

    public void stopCar() {
        position += 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
