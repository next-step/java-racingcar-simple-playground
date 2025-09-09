public class Car {
    public String carName;

    public void go(){
        // 자동차가 전진한다.
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
    public Car(String carName) {
        this.carName = carName;
    }
}

