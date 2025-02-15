import java.util.Random;

public class Car {
    private int position = 0;
    private String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public void tryMove() {
        Random rand = new Random();
        if (rand.nextInt(10) > 3) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

}
