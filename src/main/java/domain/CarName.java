package domain;

public record CarName(String value) {
    private static final int MAX_LENGTH = 5;

    public static CarName from(final String name) {
        validateNotBlank(name);
        validateLengthUnderFive(name);
        return new CarName(name);
    }

    private static void validateNotBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

    }

    private static void validateLengthUnderFive(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }
}