public class Car {
    private static final int MOVE_THRESHOLD = 4;


    private String carName;
    private int carPosition = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public int getPosition() {
        return carPosition;
    }

    public String getName() {
        return carName;
    }

    public void move(int value){
        if (isMovable(value)) {
            carPosition++;
        }
    }

    private boolean isMovable(int value) {
        return value >= MOVE_THRESHOLD;
    }
}


