package domain;

import java.util.Iterator;
import java.util.List;

public class SequenceNumberGenerator implements NumberGenerator {
    private final Iterator<Integer> sequenceNumbers;

    public SequenceNumberGenerator(Integer... sequenceNumbers) {
        this.sequenceNumbers = List.of(sequenceNumbers).iterator();
    }

    @Override
    public int generate() {
        return sequenceNumbers.next();
    }
}
