package step4.domain;

public class Car {
    private static final int FORWARD_NUM = 4;

    private final CarName carName;
    private int position =0;
    public Car(String name){
        carName= new CarName(name);
    }



    public void forwardCar(int randomNum) {
        if (randomNum >= FORWARD_NUM)
            this.position++;
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }
}