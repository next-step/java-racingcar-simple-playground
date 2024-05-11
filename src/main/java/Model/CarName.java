package Model;

public class CarName {
    private static final int MAX_NAME_COUNT = 5;
    String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        isNotNullName(name);
        isNotOverCount(name);
    }

    private void isNotOverCount(String name) {
        if (name.length() > MAX_NAME_COUNT) throw new IllegalArgumentException("이름이 5글자를 초과할 수 없습니다.");
    }

    private void isNotNullName(String name) {
        String newName = name.replaceAll("\\s+", "");
        if (newName.isEmpty()) throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
    }

    @Override
    public String toString() {
        return name;
    }
}
