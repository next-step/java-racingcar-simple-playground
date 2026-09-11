public class Car {
    private String name;
    private int pos;

    public void moveCar(int number) {
        if (shouldMove(number)) pos++;
    }
    private int makeRandomNum() {
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
    public int getPos() {
        return pos;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }

    public Car(String name) {
        this.name = name;
        pos = 0;
    }
}
