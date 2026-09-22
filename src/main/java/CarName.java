public class CarName {
    private String name;

    public CarName(String value) {
        if (name.length() > 5 | name.isEmpty()) {
            throw new IllegalArgumentException("5글자 이하의 이름을 입력하세요");
        }
        name = value;
    }

    public String getValue() {
        return name;
    }
}
