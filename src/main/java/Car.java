public class Car {
    private final String name;
    private int location;


    public Car(String carName) {
        this.name = carName;
    }

    void move() {
        moveCar(createRandomNumber());
    }

    void moveCar(int number) {
        if (number >= 4) {
            location += 1;
        }
    }

    int getLocation() {
        return location;
    }

    private int createRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
