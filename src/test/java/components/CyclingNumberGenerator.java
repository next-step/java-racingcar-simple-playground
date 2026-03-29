package components;

public class CyclingNumberGenerator implements NumberGenerator {
    private final int[] number;
    private int index = 0;
    private int arraySize;

    public CyclingNumberGenerator(int[] numberList) {
        this.number = numberList;
        this.arraySize = numberList.length;
    }

    @Override
    public int generateNumber() {
        int resultIndex = index;
        index = (index + 1) % this.arraySize;
        return number[resultIndex];
    }
}
