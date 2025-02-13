public class Car {

    private final String name;
    private int position;
    private static final int MOVE_TRIGGER = 4;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public void move(int randomValue){
        if(randomValue >= MOVE_TRIGGER){
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
