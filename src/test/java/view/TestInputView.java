package view;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class TestInputView implements InputView {
    private final Queue<String> inputs;

    public TestInputView(List<String> inputs) {
        this.inputs = new LinkedList<>(inputs);
    }

    @Override
    public String readCarName() {
        return inputs.poll();
    }

    @Override
    public String readRound() {
        return inputs.poll();
    }
}
