public class FixedNumberGenerator implements NumberGenerator{
    int fixedNumber;
    public FixedNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }
    @Override
    public int generate() {
        return this.fixedNumber;
    }
}
