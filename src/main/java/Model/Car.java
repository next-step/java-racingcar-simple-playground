package Model;

public class Car {
    CarName carName;
    int position;

    public Car(CarName carName){
        this.carName = carName;
        this.position = 0;
    }
    void move(int number){
        if(number >= 4){
            this.position += 1;
        }
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

}
