package domain;

public class RacingCar {
    private final String carName;
    private int position = 0;

    public RacingCar(String name) {
        this.carName = name;
    }

    public void move(int random) {
        if (random >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
