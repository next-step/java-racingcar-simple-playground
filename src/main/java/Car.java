import java.util.Random;

public class Car {
    String name;
    int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void moving(){
        Random random = new Random();
        if(random.nextInt(10)>=4)
            distance++;

    }

}
