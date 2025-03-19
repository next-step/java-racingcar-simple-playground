package domain;

public class CarValidator {

    public static final int MAX_CAR_NAME_SIZE = 5;

    public static void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("차량의 이름은 빈 문자열일 수 없습니다.");
        }
        if (name.length() > MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException("차량의 이름은 " + MAX_CAR_NAME_SIZE + "자 이하여야 합니다.");
        }
    }
}
