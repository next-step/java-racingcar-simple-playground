import java.util.List;
import java.util.Random;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    void move() {
        this.distance++;
    }

    void moveOrStop(int value) {
        if(value >= 4 && value <=9){
            move();
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName(){
        return name;
    }

    private void printCarInfo(){
        System.out.printf(this.name + " : ");
        for(int i=0;i<this.distance;i++)
            System.out.print("-");
        System.out.println();
    }

    public static void printCarsInfo(List<Car> cars) {
        for(Car car : cars){
            car.printCarInfo();
        }
        System.out.println();
    }
}
