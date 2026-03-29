package components;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
   Random random = new Random();
   @Override
    public int generateNumber() {
        return random.nextInt(0,10);
    }
}
