package util;

import java.util.Map;
import java.util.Random;

public class RandomValueCreator {
    public static int createRandomValue() {
        //Q : Random()과 Math.random() 차이점
        Random random = new Random();
        return random.nextInt(10);
    }

}