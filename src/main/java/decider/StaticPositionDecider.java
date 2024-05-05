package decider;

public class StaticPositionDecider implements PositionDecider {

    private final int position;

    public StaticPositionDecider(int position) {
        this.position = position;
    }

    @Override
    public int generate() {
        return position;
    }
}
