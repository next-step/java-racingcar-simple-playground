package domain;

import java.util.Random;

public class RandomMoveRule implements MoveRule {
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_RANGE = 10;
    private static final int MOVE_IF_SUCCESS = 1;

    static Random random = new Random();

    @Override
    public int move(int currentLocation){
        int number = random.nextInt(RANDOM_RANGE);
        if(number >= MOVE_THRESHOLD){
            return currentLocation + MOVE_IF_SUCCESS;
        }
        return currentLocation;
    }
}
