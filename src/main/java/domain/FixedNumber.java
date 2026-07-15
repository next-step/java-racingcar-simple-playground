package domain;

public class FixedNumber implements Number {
    private int number;

    public FixedNumber(int number) {
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }
}
