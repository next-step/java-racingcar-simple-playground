package domain.car;

import domain.strategy.AlwaysMoveStrategy;

public class CarTestFactory {
    public static Car withPosition(String name, int position) {
        return new Car(name, new AlwaysMoveStrategy(), position);
    }
}
