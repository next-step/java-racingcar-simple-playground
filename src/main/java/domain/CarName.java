package domain;

public record CarName(String name) {
    private static final int MAX_LENGTH = 5;

    public CarName {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 비어있거나 공백일 수 없습니다.");
        }

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
