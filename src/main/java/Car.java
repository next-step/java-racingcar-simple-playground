public class Car {
    private final String name;
    private int pos;

    public Car(String name) {
        this.name = name;
        this.pos = 0;
    }

    public void move(int num) {
        if (num >= 4)
            pos++;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }
}
