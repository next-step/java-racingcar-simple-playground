package domain;

public class Car {

    int location = 0;
    String name;

    public Car(String name){
        this.name = name;
    }

    public String getCarName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

}