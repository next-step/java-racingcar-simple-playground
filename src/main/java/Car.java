public class Car {
    String name;
    int position;

    public Car(String name) {
        this.name  = name;
        this.position = 0;
    }

    int move(int value) {
        if(value >= 4) {
            this.position += 1;
        }

        return this.position;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
