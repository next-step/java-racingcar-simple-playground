package model.Number;

public class IsMovable {
    private NumberGenerator movable = new RandomNumberGenerator();
    private NumberGenerator notNovable = new FixedNumberGenerator();

    private static final int MOVE_CONITION = 4;

    public Boolean getcheck() {
        //return movable.genrator() > MOVE_CONITION;
        return notNovable.genrator() > MOVE_CONITION;
    }


}
