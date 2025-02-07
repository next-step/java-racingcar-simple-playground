package common;

import java.util.List;
import java.util.Random;

public class FakeRandom extends Random {

    private  int index;
    private final List<Integer> fixedValues;

    public FakeRandom(List<Integer> fixedValues) {
        this.fixedValues = fixedValues;
    }

    @Override
    public int nextInt(int dummyBound) {
        if(index >= fixedValues.size()) {
            throw new IndexOutOfBoundsException();
        }

        return fixedValues.get(index++);
    }
}
