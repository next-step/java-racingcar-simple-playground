import exception.CarException;
import exception.ErrorMessage;

public class Car {

    private final int MIN_LENGTH = 1;
    private final int MAX_LENGTH = 5;

    private final String name;
    private int distance;

    public Car(String name) {
        validateCar(name);
        this.name = name;
        this.distance = 0;
    }

    private void validateCar(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH ) {
            throw new CarException(
                    ErrorMessage.NAME_LENGTH_INCORRECT.formatMessage(MIN_LENGTH,MAX_LENGTH));
        }
    }

    void move() {
        this.distance++;
    }

    void moveOrStop(int value) {
        if (value >= 4 && value <= 9) {
            move();
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

}
