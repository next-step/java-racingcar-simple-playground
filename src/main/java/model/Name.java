package model;

public class Name {

    private static final int MAX_LENGTH = 5;

    private final String value;

    public Name(final String value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(final String value) {
        if (value == null) {
            throw new IllegalArgumentException("자동자 이름은 null이 될 수 없습니다.");
        }

        if (value.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 칸일 수 없습니다.");
        }

        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5자를 넘길 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
