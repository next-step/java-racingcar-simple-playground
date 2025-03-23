package CarGame2.domain.service;

public class FixedGenerator implements Generator {

    private final int fixedValue;

    public FixedGenerator(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int NumberGenerate() {
        return fixedValue;
    }
}
