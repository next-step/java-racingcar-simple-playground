package car.model;

import java.util.Random;

public class RandomNumberGenerator {
    private final static int MAX_NUMBER = 10;

    public int generate(){
        Random random = new Random();
        return random.nextInt(MAX_NUMBER);
    }

}
