public class Car {
    private String name;
    private int position = 0;
    private int randomNumber = (int) (Math.random() * 10);

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {

        if (randomNumber >= 4) {
            position++;
        }
    }

}