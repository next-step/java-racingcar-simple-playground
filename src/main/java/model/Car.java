package model;

import java.util.Random;

public class Car {

    private final Random random;
    private final String name;
    private int position = 1;


    public Car(String name, Random random) {
        this.name = name;
        validateCarName(name);
        this.random = random;
    }

    private void validateCarName(String name) {
        if(name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("5자 이하의 이름을 작성해주세요.");
        }
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        return random.nextInt(10) >= 4;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
