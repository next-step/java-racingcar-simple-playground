package car.model;

import car.view.Constant;

public class Car {
    private final String name;
    private int position = 0;


    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number>= Constant.FORWARD_MIN) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
