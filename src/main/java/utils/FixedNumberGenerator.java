package utils;

public class FixedNumberGenerator implements NumberGenerator{
    private final int fixed;

    public FixedNumberGenerator(int fixed) {
        this.fixed = fixed;
    }

    @Override
    public int generate() {
        return fixed;
    }
}
