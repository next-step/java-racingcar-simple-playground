package domain;

public class RacingCar {
    private final String name;
    private int distance;

    public RacingCar(String name) {
        this.name = validateNameError(name);
        this.distance = 0;
    }

    private static String validateNameError(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다");
        }
        return name;
    }

    public void move(boolean isMovable) {
        if(isMovable) {
            this.distance++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}
