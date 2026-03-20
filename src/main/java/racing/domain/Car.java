package racing.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }
    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상이어야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에 공백을 포함할 수 없습니다.");
        }
        if (!name.matches("^[a-zA-Z0-9가-힣]*$")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에 특수문자를 포함할 수 없습니다.");
        }
    }
    public void move() {
        this.position++;
    }
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


}