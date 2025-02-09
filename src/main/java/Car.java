import util.NumberProvider;

public class Car {

    private final static int MOVE_CONDITION = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameNotNullOrEmpty(name);
        this.name = name;
    }

    private void validateNameNotNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 필수입니다.");
        }
    }

    public void move(NumberProvider numberProvider) {
        int randomNumber = numberProvider.provide();
        if (isMovable(randomNumber)) {
            position++;
        }
    }

    private boolean isMovable(int randomValue) {
        return randomValue >= MOVE_CONDITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
