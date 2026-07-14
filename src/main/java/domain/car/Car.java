package domain.car;

public class Car {
    private final String name;
    private int position;

    private static final int FORWARD_RULE = 4;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.position = 0;
    }

    public void move(int number) {
        if (number >= FORWARD_RULE) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }

        if (name.length() > 5){
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}
