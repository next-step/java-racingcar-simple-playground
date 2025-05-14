package domain;

public class RacingCar {
    private final String carName;
    private int position = 0;
    public static final int FIX_NUMBER = 4;

    public RacingCar(String name) {
        this.carName = name;
    }

    public void move(int random) {
        if (random >= FIX_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    public boolean racingCarStatus() {
        return true;
    }
}
