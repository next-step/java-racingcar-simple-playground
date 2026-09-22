public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private CarName name;
    private CarPosition position;

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new CarPosition(position);
    }

    public void moveCar(NumberGenerator randomNum) {
        int number = randomNum.generate();
        if (shouldMove(number)) {
            position.move();
        }
    }

    private boolean shouldMove(int number) {
        return number >= MOVE_THRESHOLD;
    }

    public int getLargerPosition(int maxPosition) {
        return position.getLargerPosition(maxPosition);
    }

    public boolean isSamePosition(int position) {
        return this.position.isSamePosition(position);
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return name.getValue();
    }
}
