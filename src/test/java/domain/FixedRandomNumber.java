package domain;

public class FixedRandomNumber implements RandomNumber {

    private final int number;

    public FixedRandomNumber(int number) {
        this.number = number;
    }

    @Override
    public int getRandomNumber() {
        return number;
    }
}