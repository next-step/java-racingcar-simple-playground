import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MockRandom  extends Random {
    private final Queue<Integer> values;

    public MockRandom(int... values) {
        this.values = new LinkedList<>();
        for (int value : values) {
            this.values.add(value);
        }
    }

    @Override
    public int nextInt(int bound) {
        if (values.isEmpty()) {
            throw new IllegalStateException("정해진 목 데이터를 다 사용했습니다.");
        }

        return values.poll();
    }
}
