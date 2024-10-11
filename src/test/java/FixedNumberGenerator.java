import java.util.LinkedList;
import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {
    private final Integer result;
    private final List<Integer> queue = new LinkedList<>();

    public FixedNumberGenerator(Integer integer) {
        result = integer;
    }

    public FixedNumberGenerator(List<Integer> queue) {
        this.queue.addAll(queue);
        result = queue.get(0);
    }

    @Override
    public int getNumber() {
        return result;
    }

    public List<Integer> getQueue() {
        return queue;
    }
}
