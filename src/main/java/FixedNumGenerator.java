public class FixedNumGenerator implements RandomNumber{
    private int value;

    public FixedNumGenerator(int value) {
        this.value = value;
    }

    @Override
    public int generate() {
        return value;
    }
}
