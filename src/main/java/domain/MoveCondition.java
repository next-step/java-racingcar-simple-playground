package domain;
import java.util.Random;

public class MoveCondition {
    private static final int MAX_NUMBER = 10;
    private static Random random = new Random();

    public int randomNumber(){
        return  random.nextInt(MAX_NUMBER);
    }
}
