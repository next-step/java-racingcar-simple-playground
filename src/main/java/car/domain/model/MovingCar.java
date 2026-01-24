package car.domain.model;

import car.domain.strategy.MovingStrategy;

public class MovingCar {

    private static final int THRESHOLD = 4; // 임계값
    private final Name name;
    private int location = 0;
    public MovingCar(Name name) {
        this.name = name;
    }

    public void move(MovingStrategy strategy) {
        if (strategy.canMove()) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
    public String getName() {
        return name.getValue();
    }
}
