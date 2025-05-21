public class FixedInt implements NumberGenerator {

    private int value;

    public FixedInt(int value) {
        this.value = value;
    }

    @Override
    public int generateInt() {
        return value;
    }

}
