package domain;

public class Car {

    public int carPosition;
    public String carName;

    public Car(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public void move(int randomDigit) {
        if (randomDigit >= 4) {
            go();
            return;
        }
        stop();
    }

    private void go() {
        carPosition++;
    }

    private void stop() {
        // 자동차가 정지한다.
    }

}
