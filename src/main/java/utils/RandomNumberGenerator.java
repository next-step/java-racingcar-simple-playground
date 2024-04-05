package utils;

import java.util.Random;

public class RandomNumberGenerator {

    public static int generate() {
        return new Random().nextInt(10);
    }
}
