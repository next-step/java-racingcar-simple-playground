package domain;

public class Car {
    final private String name;
    private int position = 0;
    static final int THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int randomNumber) {

        if (randomNumber >= 4) {
            position++;
        }
    }

}
