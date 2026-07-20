public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int move() {
        int randomNumber = (int) (Math.random() * 10);
        if (randomNumber >= 4) {
            return 1; // Move forward
        } else if (randomNumber < 4) {
            return 0; // Stay
        }
        return 0;
    }
}
