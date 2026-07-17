package domain.car;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

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
        validateRandomNumber(randomNumber);

        if (moveCondition.movable(randomNumber)) {
            location++;
        }
    }

    private void validateRandomNumber(int randomNumber) {
        if (randomNumber < MIN_RANDOM_NUMBER || randomNumber > MAX_RANDOM_NUMBER) {
            throw new IllegalArgumentException("랜덤값은 0에서 9 사이여야 합니다.");
        }
    }

    private void validateCarNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 명은 5자 이하여야 합니다.");
        }
    }
}
