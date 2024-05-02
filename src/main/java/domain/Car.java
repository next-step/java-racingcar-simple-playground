package domain;

public class Car {
    private int currentLocation = 0;
    public String name;

    public int getCurrentLocation() {

        return currentLocation;
    }

    public String getName() {
        return name;
    }

    public void forward() {
        currentLocation += 1;
    }

    public void severalForward(int count) {
        for (int i = 0; i < count; i++) {
            this.forward();
        }
    }

    public void check(int num, Car car) {
        if (num >= 4) {
            car.forward();
        }
    }
}
