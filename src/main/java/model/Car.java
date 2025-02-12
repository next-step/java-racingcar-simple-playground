package model;

public class Car {

    private static final int MOVE_THRESHOLD = 4; // 전진 기준 설정
    private final String carName;
    private int position = 0;

    // 자동차 이름 글자수 제한
    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        this.carName = name;
    }
    // 위치 이동
    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
