package domain;

public record CarName(
        String value
) {

    private static final int MAX_LENGTH = 5;


    public static CarName from(final String name) {
        validateName(name);
        return new CarName(name);
    }

    private static void validateName(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백일 수 없습니다.");
        }

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
