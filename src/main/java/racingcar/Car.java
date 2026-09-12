package racingcar;

public class Car {

    private final String carName;
    //final이 자바스크립트의 const와 유사?
    //private는 이제 직접 수정못하게하는? 외부에서 직접 접근 불가하게 하는것?

    private int carPosition = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    public void movePoint(int randomNumber) {
        if (randomNumber >= 4) {
            carPosition++;
        }
    }


}
