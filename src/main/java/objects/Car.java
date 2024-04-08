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

    public String getName() {
        return name;
    }

    public int getMoving() {
        return moving;
    }

    public int getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoving(int moving) {
        this.moving = moving;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move() {
        Random random = new Random();
        moving = random.nextInt(10);

        if (moving >= 4) {
            position++;

            return;
        }
    }


    public String getPositionToString() {
        String carPosition = "";
        for (int i = 0; i < position; i++) {
            carPosition += "-";
        }
        return carPosition;
    }

    public void isSamePosition(List<Car> winningCars, int position) {
        if (this.position == position) winningCars.add(this);
    }
}
