import domain.movement.NumberGenerater;

public class FixedNumberGenerater implements NumberGenerater {
    private final int[] numbers;
    private int index = 0;
    public FixedNumberGenerater(int[] numbers) {
        this.numbers = numbers;
    }

    public int generate() {
        return numbers[index++];
    }
}
