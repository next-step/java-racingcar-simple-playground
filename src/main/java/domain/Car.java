package domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private final NumberGenerator numberGenerator;
    private int totalDistance = 0;


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

    private boolean canMove(int randomValue) {
        return randomValue >= MOVE_THRESHOLD;
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

