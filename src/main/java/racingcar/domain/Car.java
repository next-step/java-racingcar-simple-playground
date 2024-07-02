package racingcar.domain;

import racingcar.RandomNumberGenerator;

public class Car {

    private static final int ACCELERATION = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private Integer position;

    public Car(String name) {
        if (name == null || name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException("자동차의 이름은 5자 이하여야합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public void move(RandomNumberGenerator generator) {
        if (generator.generate() >= ACCELERATION) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
