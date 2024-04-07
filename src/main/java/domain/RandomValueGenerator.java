package domain;

import java.util.Random;

public class RandomValueGenerator {
    public static int generate(){
        Random gen = new Random();
        return gen.nextInt(10);
    }
}
