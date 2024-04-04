package car.model;

import java.util.Random;

public class RandomNumberGenerator {

    public int generate(){
        Random random = new Random();
        return random.nextInt(10);
    }

}
