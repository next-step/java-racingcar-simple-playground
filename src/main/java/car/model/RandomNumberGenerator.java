package car.model;

import car.view.Constant;

import java.util.Random;

public class RandomNumberGenerator {

    public int generate(){
        Random random = new Random();
        return random.nextInt(Constant.RANDOM_NUMBER_MAX);
    }

}
