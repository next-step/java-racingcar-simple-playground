public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void moveCar(int number) {
        if (shouldMove(number)) position++;
    }
    public int makeRandomNum() {
        return (int)(Math.random() * 10);
    }
    private boolean shouldMove(int randomNum) {
        if (randomNum >= 4) return true;
        return false;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int pos) {
        this.position = pos;
    }
}
