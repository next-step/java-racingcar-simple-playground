public class FixedInt implements IClass {
    private int value;

    public FixedInt(int value) {
        this.value=value;
    }
    @Override
    public int giveInt() {
        return value;
    }

}
