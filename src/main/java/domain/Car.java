package domain;

public class Car {
    private static final int FORWARD_CONDITION = 4;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    //static은 클랫 전체가 공유하는 변수

    private final String carName;
    //final이 자바스크립트의 const와 유사?
    //private는 이제 직접 수정못하게하는? 외부에서 직접 접근 불가하게 하는것?

    private int carPosition = 0;

    public Car(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    public void moveIfPossible(int randomNumber) {
        if (randomNumber >= FORWARD_CONDITION) {
            carPosition++;
        }
    }

    public boolean samePosition(int otherPosition) {
        return this.carPosition == otherPosition;
    }
}
