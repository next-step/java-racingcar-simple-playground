package domain.car;

public class CarPosition {

    private int position;
    private final static int INIT_POSITION = 0;

    public CarPosition() {
        this.position = INIT_POSITION;
    }

    public void moveForward() {
        position++;
    }

    public int getCarPosition() {
        return position;
    }
}
