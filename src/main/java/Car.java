public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(boolean isMovable) {
        if(isMovable){
            this.position += 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
