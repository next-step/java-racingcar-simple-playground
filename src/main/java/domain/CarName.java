package domain;

public record CarName(String name) {
    private static final int MAX_LENGTH = 5;

    public CarName {
        validate(name);
    }

    private void validate(final String name) {
        if (name.isBlank() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름은 공백이 아니며 %d자 이하여야 합니다.", MAX_LENGTH));
        }
    }
}
