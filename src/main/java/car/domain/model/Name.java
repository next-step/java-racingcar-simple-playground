package car.domain.model;

public class Name {

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name.trim();
    }

    private void validate(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 빈 값일 수 없습니다.");
        }
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public String getValue() {
        return name;
    }

}
