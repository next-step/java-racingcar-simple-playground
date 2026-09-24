package domain;

public class CarName {
    private String name;

    public CarName(String value) {
        if (value.length() > 5 || value.isEmpty()) {
            throw new IllegalArgumentException("5글자 이하의 이름을 입력하세요");
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException("자동차 이름으로 공백 불가능");
        }
        name = value;
    }

    public String getValue() {
        return name;
    }
}
