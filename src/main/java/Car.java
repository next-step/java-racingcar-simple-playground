public class Car {
    private String name;
    private int distance;
    private final static int MOVE_THRESHOLD=4;
    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }


    public void move(int n) {
        if (n >= MOVE_THRESHOLD)
            distance++;
    }


}
