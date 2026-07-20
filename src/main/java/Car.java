public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public  void move(int randomNumber) {
        if (canMove(randomNumber)) {
            position++;
        }
    }

    private  boolean canMove(int randomNumber) {
        return  randomNumber >= 4;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
