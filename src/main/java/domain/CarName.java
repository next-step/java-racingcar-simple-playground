package domain;

public class CarName {
    private String value;
    private CarName(String value) {
        this.value = value;
    }

    public static CarName from(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5 이하여야 합니다.");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 1 이상이여야 합니다");
        }

        return new CarName(name);
    }

    public String getValue() {
        return value;
    }
}
