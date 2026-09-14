public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void moveCar(RandomNumber randomNum) {
        int number = randomNum.generate();
        if (shouldMove(number)) {
            position++;
        }
    }

    private static final int MOVE_THRESHOLD = 4;

    private boolean shouldMove(int number) {
        if (number >= MOVE_THRESHOLD) {
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }
}
