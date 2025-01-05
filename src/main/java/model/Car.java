package model;

public class Car {
    private final String name;
    private int distance = 0;
    private final RandomNumberGenerator randomNumberGenerator;
    public static final int MAX_CAR_NAME_LENGTH = 5;

    public Car(String name, RandomNumberGenerator randomNumberGenerator) {
        validateCarName(name);

        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    private void validateCarName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 비어 있어서는 안 됩니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름의 길이는 " + MAX_CAR_NAME_LENGTH + "자를 넘어서는 안 됩니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void moveByProbability() {
        if (randomNumberGenerator.generate() >= 4) {
            this.distance += 1;
        }
    }
}
