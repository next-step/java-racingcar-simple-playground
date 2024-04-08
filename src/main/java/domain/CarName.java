package domain;

public record CarName(String value) {
    private static final int NAME_LENGTH_LIMIT = 5;

    public CarName {
        validateName(value);
    }

    private void validateName(final String name) {
        if (name == null || name.isEmpty() || name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("잘못된 자동차 이름입니다.");
        }
    }
}
