package domain;

public class Name {

    private static final int MAX_LENGTH = 5;

    private final String name;

    private Name(final String name) {
        this.name = name;
    }

    public static Name from(final String name) {
        checkBlank(name);
        checkLength(name);
        return new Name(name);
    }

    public static void checkLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[Error] 이름은 " + MAX_LENGTH + "자를 초과할 수 없습니다.");
        }
    }

    public static void checkBlank(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("[Error] 이름은 공백으로 이루어질 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

}
