package domain;
import java.util.Random;

public class MoveRule {
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_RANGE = 10;
    private static final int MOVE_IF_SUCCESS = 1;
    private static final int MOVE_IF_FAILURE = 0;

    static Random random = new Random();

    static int moveRandom(int currentLocation){
        int number = random.nextInt(RANDOM_RANGE);
        if(number >= MOVE_THRESHOLD){
            return currentLocation + MOVE_IF_SUCCESS;
        }
        return currentLocation + MOVE_IF_FAILURE;
    }

    static int moveExplicit(int currentLocation, int number){
        if(number >= MOVE_THRESHOLD){
            return currentLocation + MOVE_IF_SUCCESS;
        }
        return currentLocation + MOVE_IF_FAILURE;
    }
}
