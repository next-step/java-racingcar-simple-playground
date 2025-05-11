package model;

public record Name(String value) {
    private static final int MAX_NAME_LENGTH = 5;

    public Name {
        validateEmptyName(value);
        validateNameLength(value);
    }

    private void validateEmptyName(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
    }

    private void validateNameLength(final String value) {
        if (MAX_NAME_LENGTH <= value.length()) {
            throw new IllegalArgumentException("이름을 최대 이름 길이에 맞게 입력해주세요.");
        }

    }
}
