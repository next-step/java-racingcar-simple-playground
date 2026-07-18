package domain;


public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMUM_MOVE_NUMBER = 4;

    private final String name;
    private int location;

    public Car(String carName) {
        validateNameBlank(carName);
        validateNameLength(carName);
        this.name = carName;
    }

    void move(int number) {
        if (number >= MINIMUM_MOVE_NUMBER) {
            location += 1;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private void validateNameBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름에 빈 문자나 공백만으로 구성할 수 없습니다.");
        }
    }
}
