import domain.movement.CarMovement;

public class FixedMovement implements CarMovement {
    private final int[] numbers;
    private int index = 0;
    public FixedMovement(int[] numbers) {
        this.numbers = numbers;
    }

    public int generate() {
        return numbers[index++];
    }
}
