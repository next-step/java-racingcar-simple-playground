import domain.NumberGenerator;

public class MovableNumberGenerator implements NumberGenerator {

    public static final int MOVABLE_NUMBER = 4;

    @Override
    public int generateNumber() {
        return MOVABLE_NUMBER;
    }

}
