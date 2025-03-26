import CarGame2.domain.service.NumberGenerator;

public class FixedNumberGenerator implements NumberGenerator {

    private final int fixedValue;

    public FixedNumberGenerator(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int generate() {
        return fixedValue;
    }
}
