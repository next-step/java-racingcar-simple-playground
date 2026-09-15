public class FixedNumGenerator implements NumberGenerator {
    private int value;

    public FixedNumGenerator(int value) {
        this.value = value;
    }

    @Override
    public int generate() {
        return value;
    }
}
