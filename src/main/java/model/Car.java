package model;

public class Car {
    private final String name;
    private int distance = 0;
    private final RandomNumberGenerator randomNumberGenerator;

    public Car(String name, RandomNumberGenerator randomNumberGenerator) {
        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
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
