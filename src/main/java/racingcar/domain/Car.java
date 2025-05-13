package racingcar.domain;

import racingcar.domain.vo.Name;
import racingcar.domain.vo.Position;
import racingcar.util.RandomNumberGenerator;

public class Car {
    private static final int MOVING_STANDARD = 4;

    private final Name name;
    private Position position;

    public Car(final Name name) {
        this.name = name;
        this.position = new Position();
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position.value();
    }

    public void move(final RandomNumberGenerator randomNumberGenerator) {
        if (randomNumberGenerator.generate() >= MOVING_STANDARD) {
            position = position.forward();
        }
    }
}
