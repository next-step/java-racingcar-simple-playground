import java.util.Random;

public class Car {
    private static final int MOVE_AVALIABLE_MIN = 4;
    private String name;
    private int position;
    public Car(String name ){
        this.name = name;
    }

    public void move(int RANDOM_NUM){
        if(isMovable(RANDOM_NUM)){
            position++;
        }
    }

    private boolean isMovable(int RANDOM_NUM){
        return  RANDOM_NUM >=MOVE_AVALIABLE_MIN;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }
}
