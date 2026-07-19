package domain.car;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final MoveCondition moveCondition;
    private int location;

    public Car(String name, int location) {
        this(name, location, new DefaultMoveCondition());
    }

    public Car(String name, int location, MoveCondition moveCondition) {
        validateCarNameLength(name);
        this.name = name;
        this.location = location;
        this.moveCondition = moveCondition;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void moveCar(int randomNumber) {
        if (moveCondition.movable(randomNumber)) {
            location++;
        }
    }

    private void validateCarNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 명은 5자 이하여야 합니다.");
        }
    }
}
