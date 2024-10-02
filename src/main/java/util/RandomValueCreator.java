package util;

import java.util.Map;
import java.util.Random;

public class RandomValueCreator {

    private static final int MAX_BOUND_NUMBER = 10;

    public static int createRandomValue() {
        //Q : Random()과 Math.random() 차이점
        Random random = new Random();
        return random.nextInt(MAX_BOUND_NUMBER);
    }

}