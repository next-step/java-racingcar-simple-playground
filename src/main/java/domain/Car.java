package domain;

public class Car {

    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public void forward(){
        this.position++;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

}
