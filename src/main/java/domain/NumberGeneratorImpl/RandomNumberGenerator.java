package domain.NumberGeneratorImpl;

import domain.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {
    private final int MAX_RANDOM_NUMBER = 10;
    private final int MIN_RANDOM_NUMBER = 0;

    @Override
    public int generate(){
        return (int)(Math.random()*(MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER) + MIN_RANDOM_NUMBER);
    }
}
