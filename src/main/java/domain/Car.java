package domain;

public class Car {

    private static final int MOVABLE_NUMBER = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int location;

    public Car(String name, int location) {
        validateCarNameLength(name);
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void moveCar(int randomNumber) {
        if (randomNumber >= MOVABLE_NUMBER) {
            location++;
        }
    }


    private void validateCarNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
