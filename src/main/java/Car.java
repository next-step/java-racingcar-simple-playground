public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void moveCar(NumberGenerator randomNum) {
        int number = randomNum.generate();
        if (shouldMove(number)) {
            position++;
        }
    }

    private boolean shouldMove(int number) {
        return number >= MOVE_THRESHOLD;
    }

    public int getLargerPosition(int maxPosition) {
        return Math.max(position, maxPosition);
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public void print() {
        System.out.println(name + " : " + "-".repeat(position));
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
