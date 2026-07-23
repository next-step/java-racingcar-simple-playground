package domain;

public class Car {
    private String name;
    private int position;
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public void move(int randomNumber) {
        if(randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}