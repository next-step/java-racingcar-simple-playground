package model;

import java.util.Random;

public class CarRandomNumberGenerator implements RandomNumberGenerator {
    Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(10);
    }
}
