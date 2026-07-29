package domain;

public class Car {
    private static final int THRESHOLD = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차이름은 5자를 넘길수 없습니다.");
        }
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int randomNumber) {

        if (randomNumber >= THRESHOLD) {
            position++;
        }
    }

}
