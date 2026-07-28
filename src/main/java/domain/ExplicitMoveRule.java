package domain;

public class ExplicitMoveRule implements MoveRule {

    private static final int MOVE_THRESHOLD = 4;
    private static final int MOVE_IF_SUCCESS = 1;

    private final int number;

    public ExplicitMoveRule(int number){
        this.number = number;
    }

    @Override
    public int move(int currentLocation){
        if(number >= MOVE_THRESHOLD){
            return currentLocation + MOVE_IF_SUCCESS;
        }
        return currentLocation;
    }
}
