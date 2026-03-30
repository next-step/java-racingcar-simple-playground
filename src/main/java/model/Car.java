package model;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_FORWARD_NUMBER = 4;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        // 1. 공백이나 null인지 먼저 검사
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있거나 공백일 수 없습니다.");
        }

        // 2. 그 다음 글자 수(5자 초과) 검사
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void move(int number) {
        if (number >= MIN_FORWARD_NUMBER) {
            this.position++;
        }
    }

    public boolean isAtPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public String getName() { return name; }
    public int getPosition() { return position; }
}
