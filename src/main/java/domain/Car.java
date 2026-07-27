package domain;
import java.util.Random;

public class Car {

    private static final int MAX_NAME_LENGTH = 10;
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_RANGE = 10;

    Random random = new Random();

    private int location = 0;
    private final String name;

    public Car(String name){
        this.name = name;

        // 예외처리 - 이름의 길이는 1~10자로 제한
        if(name.isBlank()){
            throw new IllegalArgumentException("각 이름은 1자 이상으로 입력해주세요.");
        }
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("각 이름은 10자 이하로 입력해주세요.");
        }
    }

    public String getCarName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void move(){
        int number = random.nextInt(RANDOM_RANGE);
        decide(number);
    }

    public void decide(int number) {
        if(number >= MOVE_THRESHOLD){
            location++;
        }
    }

}