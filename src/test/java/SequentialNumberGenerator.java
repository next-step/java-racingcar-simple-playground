import domain.NumberGenerator;

import java.util.List;

public class SequentialNumberGenerator implements NumberGenerator {
    private List<Integer> sequentialNumber;
    private int i = 0;

    public SequentialNumberGenerator(List<Integer> sequentialNumber) {
        this.sequentialNumber = sequentialNumber;
    }

    @Override
    public int generate() {
        int number = sequentialNumber.get(i);
        i++;
        return number;
    }

    public void addSequentialNumber(List<Integer> addedSequentialNumber) {
        for (int i = 0; i < addedSequentialNumber.size(); i++) {
            sequentialNumber.add(addedSequentialNumber.get(i));
        }
    }

}
