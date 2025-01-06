import java.util.Random;

public class Car {
    private String name;
    public int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void move () {
        Random random = new Random();

        int randomValue = random.nextInt(10);

        if (randomValue >= 4) {
            distance++;
        }
    }
}
