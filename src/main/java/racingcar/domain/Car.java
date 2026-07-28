package racingcar.domain;

public class Car {
    public static final int CAR_MOVING_THRESHOLD = 4;
    public static final int CAR_MOVE_ONCE_DISTANCE = 1;
    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 공백이 아닌 5자 이하 글자여야합니다.");
        }
        this.location = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public void moveCar(int randomValue) {
        if (randomValue >= CAR_MOVING_THRESHOLD) {
            this.location += CAR_MOVE_ONCE_DISTANCE;
        }
    }

}

