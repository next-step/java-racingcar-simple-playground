package domain;

public class Name {
    private static final int MAX_LENGTH = 5;
    public static final String INVALID_NAME_ERROR = "[ERROR] 이름은 비어 있을 수 없습니다.";
    public static final String NAME_TOO_LONG_ERROR = "[ERROR] 이름은 5자 이하여야 합니다.";

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validate(String value) {
        validateNotEmpty(value);
        validateLength(value);
    }

    private void validateNotEmpty(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR);
        }
    }

    private void validateLength(String value) {
        if (value.trim().length() > MAX_LENGTH) {
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
