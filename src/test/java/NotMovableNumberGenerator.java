import domain.NumberGenerator;

public class NotMovableNumberGenerator implements NumberGenerator {

    public static final int NOT_MOVABLE_NUMBER = 3;

    @Override
    public int generateNumber() {
        return NOT_MOVABLE_NUMBER;
    }

}
