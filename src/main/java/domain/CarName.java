package domain;

public class CarName {
    String value;
    public CarName(String value) {
        this.value = value;
    }

    public static CarName stringToName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5 이하여야 합니다.");
        }

        return new CarName(name);
    }
}
