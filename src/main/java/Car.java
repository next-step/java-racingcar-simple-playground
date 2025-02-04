import java.util.Random;

public class Car {
    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLocation() {
        return location;
    }
    public void setLocation(int location) {
        this.location = location;
    }

    public void move(){
        int speed = new Random().nextInt(10);
        this.location = calculateNextLocation(speed);

    }

    private int calculateNextLocation(int speed){
        if(speed >= 4){
            return this.location+1;
        }
        return this.location;
    }





}
