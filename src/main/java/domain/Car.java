package domain;

public class Car {
    static final int THRESHOLD = 4;
    final private String name;
    private int position = 0;

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
