package domain;

public class RandomGenerator implements NumberGenerator {

    @Override
    public int getNumber() {
        return (int) (Math.random() * 10);
    }
}
