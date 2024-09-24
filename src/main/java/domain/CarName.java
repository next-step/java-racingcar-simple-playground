package domain;

public record CarName(String value) {
    private static final int MAX_LENGTH = 5;

    public static CarName from(final String name) {
        validateName(name);
        return new CarName(name);
    }

    public static void validateName(final String name) {
        // 이름에서 발생할 수 있는 예외) 이름이 없을 경우
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        // 3단계 기능 요구사항(자동차 이름은 5자 이하)
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }
}
