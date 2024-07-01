public class Car {
    public final String name;
    public int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= 4) {
            position += 1;
        }
    }
}
