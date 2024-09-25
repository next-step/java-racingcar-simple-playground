package domain;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void moveCar(){
        if(CarControl.isMovable()){
            position++;
        }
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }
}
