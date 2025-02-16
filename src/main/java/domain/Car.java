package domain;

public class Car {

    private static final int MAX_LENGTH_OF_NAME = 5;

    private final String name;
    private int moveDistance = 1;

    private Car(String name) {
        validateName(name);

        this.name = name;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public String getName() {
        return this.name;
    }

    public int getMoveDistance() {
        return this.moveDistance;
    }

    public void goForward() {
        this.moveDistance++;
    }

    private static void validateName(String name) {
        if (isIllegalName(name)) {
            throw new IllegalArgumentException(String.format("Car의 이름은 %d보다 길거나 비어있을 수 없습니다: \"%s\"", MAX_LENGTH_OF_NAME, name));
        }
    }

    private static boolean isIllegalName(String name) {
        return isNull(name) || isBlank(name) || isLongerThanMaxLength(name);
    }

    private static boolean isNull(Object obj) {
        return obj == null;
    }

    private static boolean isBlank(String string) {
        return string.trim().isEmpty();
    }

    private static boolean isLongerThanMaxLength(String name) {
        return name.length() > MAX_LENGTH_OF_NAME;
    }

}
