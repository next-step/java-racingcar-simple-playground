package domain;

public class FixedNumber implements Number {
    private final int number;

    public FixedNumber(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }
}
