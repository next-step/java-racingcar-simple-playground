package domain;

public class CarSnapshot {
    private final String name;
    private final int position;

    public CarSnapshot(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarSnapshot from(Car car) {
        return new CarSnapshot(car.getName(), car.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
