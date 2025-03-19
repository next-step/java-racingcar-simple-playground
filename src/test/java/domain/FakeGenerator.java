package domain;

import java.util.Queue;

public class FakeGenerator implements NumberGenerator {

    Queue<Integer> queue;

    public FakeGenerator(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public int getNumber() {
        return queue.remove();
    }

}
