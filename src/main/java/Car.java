public class Car {

    private final String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(int number) {
        if (canMove(number)) {
            this.distance++;
        }
    }

    private boolean canMove(int number) {
        return number >= 4;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
		return name;
    }
}
