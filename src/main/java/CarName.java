import java.util.Objects;

public final class CarName {
    private final String value;

    public CarName(String value) {
        this.value = normalize(value);
        validate(this.value);
    }

    private String normalize(String value) {
        return Objects.requireNonNull(value).trim();
    }

    private void validate(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (value.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public String value() {
        return value;
    }
}