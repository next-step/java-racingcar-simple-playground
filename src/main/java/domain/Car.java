package domain;

public class Car {
    public String carName;
    public int carPosition;

    public void go(){
        carPosition++;
    }

    public void stop(){
        // 자동차가 정지한다.
    }
    public void move(int randomDigit){
        if(randomDigit>=4){
            go();
            return;
        }
        stop();
    }
    public Car(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }
}