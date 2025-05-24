package domain;

public class GeneratedFixedInt implements NumberGenerator {

    private int value;

    public GeneratedFixedInt(int value) {
        this.value = value;
    }

    @Override
    public int generateInt() {
        return value;
    }

}
