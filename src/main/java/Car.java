public class Car {
    private static final int MOVE_DISTANCE = 1;
    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void moveForward() {
        position += MOVE_DISTANCE;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

}
