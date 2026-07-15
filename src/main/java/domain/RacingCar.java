package domain;

public class RacingCar {
    private String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(int num) {
        if (num >= 4) {
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