package org.duckstudy.generator;

public class RandomValueGenerator implements Generator {

    private static final int MAX_RANDOM_VALUE = 9;

    @Override
    public int generateValue() {
        return (int) (Math.random() * MAX_RANDOM_VALUE);
    }
}
