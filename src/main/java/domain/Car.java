package domain;

public class Car {
    private int position = 0;
    private final String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    public void move() {
        this.position++;
    }

    public boolean isEqualPosition(Car other) {
        return this.position == other.position;
    }

    public static int comparePositionOfCarObject(Car car1, Car car2) {
        return Integer.compare(car1.position, car2.position);
    }

}
