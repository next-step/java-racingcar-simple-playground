package domain;

public class Name {
    private static final int MAX_LENGTH = 5;
    private static final String INVALID_NAME_ERROR = "[ERROR] 이름은 비어 있을 수 없습니다.";
    private static final String NAME_TOO_LONG_ERROR = "[ERROR] 이름은 5자 이하여야 합니다.";

    private final String value;

    public Name(String rawInput) {
        validateNotNull(rawInput);
        String trimmedInput = rawInput.trim();
        validateNotEmpty(trimmedInput);
        validateLength(trimmedInput);
        this.value = trimmedInput;
    }

    public String getValue() {
        return value;
    }

    private void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR);
        }
    }

    private void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR);
        }
    }

    private void validateLength(String input) {
        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_TOO_LONG_ERROR);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Name other = (Name) obj;
        return this.value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
