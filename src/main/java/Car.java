public class Car {
    private final String name;
    private int position;

    public Car(final String name) {
        validateEmptyName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateEmptyName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
    }

    public void canMove(int randomValue) {
        if (randomValue > 3) {
            position++;
        }
    }
}
