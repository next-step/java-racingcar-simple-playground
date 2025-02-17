package model;

public class Car {

    private static final int MOVE_THRESHOLD = 4; // 전진 기준 설정
    private static final int MAX_NAME_LENGTH = 5; // 자동차 이름 최대 글자수 설정
    private final String cars;
    private int position = 0;

    public Car(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
        this.cars = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getCars() {
        return cars;
    }

    public int getPosition() {
        return position;
    }
}
