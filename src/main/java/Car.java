
public class Car {

    private static final int MOVABLE_MIN = 4;
    private String name;
    private int position;

    public Car(String name ){
        this.name = name;
        this.position = 0;
    }

    public void move(int num){
        if(isMovable(num)){
            position++;
        }
    }

    private boolean isMovable(int num){
        return  num >=MOVABLE_MIN;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }
}
