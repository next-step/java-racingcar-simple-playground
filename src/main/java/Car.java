public class Car {
    private final String name;
    private int location;

    public int randomNumber = (int) (Math.random()*10);

    public Car(String carName) {
        this.name = carName;
    }

    void move(int randomNumber) {
        if (randomNumber >= 4) {
            location += 1;
        }
    }

    int getLocation() {
        return location;
    }
}
