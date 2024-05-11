package objects;


import java.util.List;
import java.util.Random;


public class Car {

    private String name;
    private int moving;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.moving = -1;
    }

    public void initOnlyTestCar(String name, int moving, int position) {
        this.name = name;
        this.moving = moving;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


    public void move(int start, int end) {

        Random random = new Random();
        moving = random.nextInt(end) + start;

        if (moving >= 4) position++;

    }


    public String getPositionToString() {

        StringBuilder carPosition = new StringBuilder();

        for (int i = 0; i < position; i++) {
            carPosition.append("-");
        }

        return carPosition.toString();
    }

    public void samePosition(List<Car> winningCars, int position) {
        if (this.position == position) winningCars.add(this);
    }
}
