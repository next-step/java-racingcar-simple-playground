import domain.NumberGenerator;

class FixedNumberGenerator implements NumberGenerator {
    private final int number;

    FixedNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
