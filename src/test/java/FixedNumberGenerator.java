import java.util.LinkedList;
import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {
    private final Integer result;
    private final List<Integer> queue = new LinkedList<Integer>();

    public FixedNumberGenerator(Integer integer) {
        result = integer;
    }

    @Override
    public int getNumber() {
        return result;
    }
}
