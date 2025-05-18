package domain;

import domain.generator.NumberGenerator;

public class Car {

    private final String name;
    private int position;
    private final NumberGenerator generator;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name, NumberGenerator generator) {
        validateName(name);
        this.name = name.trim();
        this.position = 0;
        this.generator = generator;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 값이 될 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public void movePosition() {
        if (generator.generate() >= MOVE_THRESHOLD ) {
            position++;
        }
    }
}
