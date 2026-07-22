package domain;

import java.util.Random;

public class MakeRandomNum implements NumberGenerator {
    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
