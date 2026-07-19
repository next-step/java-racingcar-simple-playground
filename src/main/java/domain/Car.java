package domain;

public class Car {
    private final String name;
    private final NumberGenerator numberGenerator;
    private int totalDistance = 0;
    private static final int MAX_NAME_LENGTH = 5;

    public Car(String name, NumberGenerator numberGenerator) {
        validateName(name);
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public boolean canMove(int randomValue) {
        return randomValue >= 4;
    }

    public void move() {
        if (canMove(numberGenerator.getNumber())) {
            totalDistance++;
        }
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }
}

